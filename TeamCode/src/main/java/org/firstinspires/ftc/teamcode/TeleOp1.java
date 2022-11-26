package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.nio.channels.ConnectionPendingException;

@TeleOp
public class TeleOp1 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        //drive train
        DriveTrain driveTrain = new DriveTrain(hardwareMap, this);

        Arm arm = new Arm(hardwareMap);
        Claw claw = new Claw(hardwareMap, this);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            /*claw.setPosition(0.42, 0.58);
            sleep(10000);
            claw.setPosition(0.58, 0.42);
            sleep(10000);*/


            //hold right bumper to close the claw
            if (gamepad2.right_bumper)
                claw.close();
            else //release right bumper to open the claw
                claw.open();

            //arm
            if (gamepad2.y) { //press Y, go to the front position
                arm.setClawPosition(1);
            } else if (gamepad2.b) { //press b, go to the right position
                arm.setClawPosition(2);
            } else if (gamepad2.x) { //press x, go to the left position
                arm.setClawPosition(0);
            }

            //use left stick y to set the power slide motors
            arm.moveSlide(-gamepad2.left_stick_y);

            double slide_height = arm.getDistanceINCH();
            telemetry.addData("Slide Height",slide_height );

            /*
            if (gamepad2.y) {
                arm.setTurretPosition(0.165); //front position
            } else if (gamepad2.x) {
                arm.setTurretPosition(0.265); //right position
            } else if (gamepad2.b) {
                arm.setTurretPosition(0.065); //left position
            }

            telemetry.addLine(String.format("\nDetected turret position=%f", arm.getTurretPosition()));
            */


            //drive train
            driveTrain.setPower(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            telemetry.update();
        }
    }
}
