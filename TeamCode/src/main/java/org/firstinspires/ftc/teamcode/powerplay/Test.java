package org.firstinspires.ftc.teamcode.powerplay;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Test", group="Linear Opmode")
@Disabled
public class Test extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        //drive train
        DriveTrain driveTrain = new DriveTrain(hardwareMap, this, true);
        driveTrain.resetAndRunUsingEncoder();
        //reset drive train's yaw angle
        driveTrain.resetYaw();

        //arm hardware
        //Arm arm = new Arm(hardwareMap);
        Claw claw = new Claw(hardwareMap, this);
        Slide slide = new Slide(hardwareMap, this);
        slide.runWithEncoder();
        Turret turret = new Turret(hardwareMap, slide);


        Aligner aligner = new Aligner(hardwareMap, this);
        //April tag detector
        SleeveDetector sleeveDetector = new SleeveDetector(hardwareMap, this);
        int location = 2;

//        // Important Step 2: Get access to a list of Expansion Hub Modules to enable changing caching methods.
//        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
//
//        // --------------------------------------------------------------------------------------
//        // Run test cycles using AUTO cache mode
//        // In this mode, only one bulk read is done per cycle, UNLESS you read a specific encoder/velocity item AGAIN in that cycle.
//        // --------------------------------------------------------------------------------------
//
//        // Important Step 3: Option A. Set all Expansion hubs to use the AUTO Bulk Caching mode
//        for (LynxModule module : allHubs) {
//            module.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
//        }

        while (!isStarted() && !isStopRequested()) {

            // Arm arm = new Arm(hardwareMap);
            location = sleeveDetector.detectPosition();

            telemetry.addLine(String.format("\n\nLocation = %d", location));
            telemetry.update();

            sleep(20);
        }

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

//
//
//            if(gamepad1.right_bumper) {
//                sleep(10000);
//
//                SquareToPoolResult result = driveTrain.squareToPoles(1, -0.1, 5000);
//                telemetry.addData("left pole", result.left);
//                telemetry.addData("current distance", result.distance);
//                telemetry.update();
//            }

//            if(gamepad1.right_bumper){
//                aligner.moveDown();
//            }
//            else{
//                aligner.moveUp();
//            }

            //slide.moveTo(5, 0.8);
            //sleep(5000);
           // slide.moveTo(20, 0.8);
            //sleep(5000);
            //slide.moveTo(0, 0.8);


            ////use left stick y to set the power slide motors
            //slide.setPower(-gamepad2.left_stick_y);
            //telemetry.addData("Slide height inches", slide.getSlideHeightInches());

            ////color sensor
            //NormalizedRGBA colors = colorSensor.getNormalizedColors();
            //telemetry.addData("Red", colors.red);
            //telemetry.addData("Blue", colors.blue);
            //telemetry.addData("Alpha", colors.alpha);

            //driveTrain.moveToPole(3, 0.6);

            //telemetry.update();

//            if(gamepad2.left_bumper) {
//                if (gamepad2.dpad_down)
//                    slide.moveToJunctionWithoutWaiting(0, 0.4);
//                else if (gamepad2.dpad_left)
//                    slide.moveToJunctionWithoutWaiting(1, 0.4);
//                else if (gamepad2.dpad_up)
//                    slide.moveToJunctionWithoutWaiting(2, 0.4);
//                else if (gamepad2.dpad_right)
//                    slide.moveToJunctionWithoutWaiting(3, 0.4);
//            }
//            else
//                slide.setPower(-gamepad2.left_stick_y);
//
//
            //turn test
            if(gamepad2.x)
                //driveTrain.moveLeft(10, .5);
                driveTrain.turnToGyroHeading(90, 0.5); //original 90
            if(gamepad2.y)
                //driveTrain.moveLeft(5, .5);
                driveTrain.turnToGyroHeading(-90, 0.5); // original -90
            if(gamepad2.b)
                //driveTrain.moveLeft(-10, .5);
                //driveTrain.turnClockwise(90, 0.5);
                driveTrain.fineTuneToGyroHeading(90, 0.2, 300);
            if(gamepad2.a)
                //driveTrain.moveLeft(-5, .5);
                //driveTrain.turnClockwise(-90, 0.5);
                driveTrain.fineTuneToGyroHeading(-90, 0.2, 300);
            if(gamepad1.dpad_up)
                driveTrain.wallSquaring(0.3, 0);
//
//            //ramp test
//            if(gamepad1.y)
//                driveTrain.moveForward(60, 0.8);
//            if(gamepad1.b)
//                driveTrain.moveForwardRamp(60, 0.1, 1.0, 1.25);
//
//            if(gamepad1.x)
//                driveTrain.moveForward(-31, 0.5);
//            if(gamepad1.a)
//                driveTrain.moveForwardRamp(-31, 0.1, 0.9, 1.25);
//
//            if(gamepad1.left_bumper) {
//                SquareToPoolResult result = driveTrain.squareToPoles(1, 0.1, 1);
//                telemetry.addData("left pole", result.left);
//                telemetry.addData("current distance", result.distance);
//                telemetry.update();
//
//                sleep(10000);
//            }
//

//            sleep(10000);
//
//            if(gamepad1.right_bumper) {
//                SquareToPoolResult result = driveTrain.squareToPoles(1, -0.1, 5000);
//                telemetry.addData("left pole", result.left);
//                telemetry.addData("current distance", result.distance);
//                telemetry.update();
//            }
//
//            if(gamepad2.left_bumper) {
//                SquareToPoolResult result = driveTrain.squareToPoles(1, 0.2, 1000);
//                telemetry.addData("left pole", result.left);
//                telemetry.addData("current distance", result.distance);
//                telemetry.update();
//
//                sleep(10000);
//            }
//
//            if(gamepad2.right_bumper) {
//                SquareToPoolResult result = driveTrain.squareToPoles(1, -0.2, 1000);
//                telemetry.addData("left pole", result.left);
//                telemetry.addData("current distance", result.distance);
//                telemetry.update();
//
//                sleep(10000);
//            }
//
            telemetry.addData("Side left distance", driveTrain.getLeftDistanceINCH());
            telemetry.addData("Side right distance", driveTrain.getRightDistanceINCH());
//            telemetry.addData("Front left distance", driveTrain.getFrontLeftDistanceINCH());
//            telemetry.addData("Front right distance", driveTrain.getFrontRightDistanceINCH());
            telemetry.update();
//
//            sleep(100);
        }
    }
}