package $package$

import cats.data.EitherT
import cats.effect.testing.scalatest._
import cats.effect.testing.scalatest.scalacheck.EffectCheckerAsserting
import cats.effect.{IO, Sync}
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.{CheckerAsserting, ScalaCheckPropertyChecks}

class MySpec extends AsyncIOSpec with Matchers with ScalaCheckPropertyChecks {

  "My IO Code" - {

    "works with effect-full property-based testing" in {
      forAll { (l1: List[Int], l2: List[Int]) =>
        IO.delay(l1.size + l2.size shouldBe (l1 ::: l2).size)
      }
    }
  
    implicit def ioCheckingAsserting[A]: CheckerAsserting[IO[A]] { type Result = IO[Unit] } =
      new EffectCheckerAsserting
  }
  
  "My EitherT[IO, Throwable, A] code" - {
  
    type Eff[A] = EitherT[IO, Throwable, A]

    "works with effect-full property-based testing" in {
      val check = forAll { (l1: List[Int], l2: List[Int]) =>
        Sync[Eff].delay(l1.size + l2.size shouldBe (l1 ::: l2).size)
      }

      check.leftSemiflatMap[Unit](IO.raiseError).merge.assertNoException
    }

    implicit def checkingAsserting[A]: CheckerAsserting[Eff[A]] { type Result = Eff[Unit] } =
      new EffectCheckerAsserting
  }

}