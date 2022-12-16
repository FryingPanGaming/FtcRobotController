package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Red Left Side", group="Linear Opmode")
public class AutoRedLeft extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        //drive train
        DriveTrain driveTrain = new DriveTrain(hardwareMap, this);
        driveTrain.runWithEncoder();
        //reset drive train's yaw angle
        driveTrain.resetYaw();

        //arm hardware
        Arm arm = new Arm(hardwareMap);
        arm.slideRunWithEncorder();

        //April tag detector
        SleeveDetector sleeveDetector = new SleeveDetector(hardwareMap, this);
        int location = 2;

        while (!isStarted() && !isStopRequested()) {

            // Arm arm = new Arm(hardwareMap);
            location = sleeveDetector.detectPosition();

            telemetry.addLine(String.format("\n\nLocation = %d", location));
            telemetry.update();

            sleep(20);
        }

        waitForStart();

        if (isStopRequested()) return;


        if (location == 1) {
            driveTrain.moveLeft(33, 0.4);
            sleep(200);
            driveTrain.moveLeft(-3,0.4);
            sleep(100);
            driveTrain.moveForward(36, 0.4);
        } else if (location == 2) {
            driveTrain.moveLeft(4, 0.4);
            sleep(100);
            driveTrain.moveForward(36, 0.4);
        } else {
            driveTrain.moveLeft(-25, 0.4);
            sleep(200);
            driveTrain.moveForward(36, 0.4);
        }
    }
}