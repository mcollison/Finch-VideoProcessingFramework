package newcastleuniversity.joehonour.movement_detection.movements

import newcastleuniversity.joehonour.movement_detection.objects.MovementObject

case class WalkingMovement(override val uuid: String,
                           override val fromLocationX: Double,
                           override val fromLocationY: Double,
                           override val toLocationX: Double,
                           override val toLocationY: Double,
                           override val averageDisplacement: Double) extends DetectedMovement
{
  override def movement_type: String = "walking"
}

object WalkingMovement {

  def buildWalkingMovementFrom(movementObjects: Iterable[MovementObject]): WalkingMovement
    = MovementBuilderHelper.buildMovementFrom(movementObjects, WalkingMovement(_, _, _, _, _, _))
}
