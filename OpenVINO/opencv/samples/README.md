How to build these examples
===========================

On Linux/OSX:
```
mkdir -p samples_build && pushd samples_build
cmake <OpenVINO_ROOT>/opencv/share/OpenCV/samples
cmake --build .
popd
```

On Windows:
```
mkdir samples_build
pushd samples_build
cmake -G"Visual Studio 14 2015 Win64" <OpenVINO_ROOT>\opencv\samples
cmake --build . --config Release
popd samples_build
```

How to use these examples
=========================

Although some of examples display their results in windows it can be more convenient to run them from the console. So you will be able to pass command line arguments and observe error messages printed to standard output.

Details on each application are in following sections.

openvino_sample_bgfg_segm.exe
--------------------------
```
This sample demonstrates background segmentation.
Usage: openvino_sample_bgfg_segm.exe [params]

        -c, --camera (value:0)
                use video stream from camera (device index starting from 0)
        --file_name, --fn
                use video file as input
        -h, --help
                show help message
        -m, --method (value:mog2)
                method: background subtraction algorithm ('knn', 'mog2')
```
##### Examples:

- Run MOG2 background subtraction algorithm on video stream from default camera:

    `<app>`

- Run KNN background subtraction on video stream from file:

    `<app> --file_name=<path-to-file> --method=knn`


openvino_sample_colorization.exe
-----------------------------
```
This sample demonstrates recoloring grayscale images with dnn.
This program is based on:
  http://richzhang.github.io/colorization
  https://github.com/richzhang/colorization
Download caffemodel and prototxt files:
  http://eecs.berkeley.edu/~rich.zhang/projects/2016_colorization/files/demo_v2/colorization_release_v2.caffemodel
  https://raw.githubusercontent.com/richzhang/colorization/master/colorization/models/colorization_deploy_v2.prototxt

Usage: openvino_sample_colorization.exe [params]

        -h, --help
                print this help message
        --image (value:space_shuttle.jpg)
                path to image file
        --model (value:colorization_release_v2.caffemodel)
                model weights
        --opencl
                enable OpenCL
        --proto (value:colorization_deploy_v2.prototxt)
                model configuration
```
##### Examples:

- Colorize the image using downloaded network:

    `<app> --model=<path-to-caffemodel> --proto=<path-to-prototxt> --image=<path-to-image>`

**Note:**  users have to download DNN model files (layout in .prototxt  and weights in .caffemodel) from the Internet manually

openvino_sample_dense_optical_flow.exe
-----------------------------------
```
This sample demonstrates using of dense optical flow algorithms.
Usage: openvino_sample_dense_optical_flow.exe [params]

        -a, --algorithm (value:fb)
                algorithm (supported: 'fb', 'tvl')
        -c, --camera (value:0)
                capture video from camera (device index starting from 0)
        --cpu, -m
                run without OpenCL
        -h, --help
                print help message
        -o, --original
                use original frame size (do not resize to 640x480)
        -v, --video
                use video as input
```
##### Examples:

- Run Farneback optical flow algorithm (OpenCL implementation) on video stream from default camera:

    `<app>`

- Run Farneback optical flow algorithm (CPU implementation) on video stream from file:

    `<app> --video=<path-to-file> --cpu`


openvino_sample_opencl_custom_kernel.exe
-------------------------------------
```
Demonstrates running custom OpenCL kernels by means of OpenCV T-API interface.
Usage: openvino_sample_opencl_custom_kernel.exe [params]

        -h, --help
                print help message
        -i, --input
                specify input image
```
##### Examples:

- Generate and process syntetic image with built-in OpenCL kernel:

    `<app>`

- Process provided image with built-in OpenCL kernel:

    `<app> --input=<path-to-image>`


openvino_sample_opencv_version.exe
-------------------------------
```
This sample outputs OpenCV version and build configuration.
Usage: openvino_sample_opencv_version.exe [params]

        -b, --build
                print complete build info
        -h, --help
                print this help
```
##### Examples:

- Show OpenCV version:

    `<app>`

- Show complete OpenCV build configuration:

    `<app> --build`


openvino_sample_peopledetect.exe
-----------------------------
```
This sample demonstrates the use of the HoG descriptor.
Usage: openvino_sample_peopledetect.exe [params]

        -c, --camera (value:0)
                capture video from camera (device index starting from 0)
        -h, --help
                print help message
        -v, --video
                use video as input
```
##### Examples:

- Run built-in pedestrian detection algorithm on video stream from camera:

    `<app>`

- Run built-in pedestrian detection algorithm on video stream from file:

    `<app> --video=<path-to-file>`
