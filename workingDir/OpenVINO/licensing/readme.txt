------------------------------------------------------------------------
Intel(R) Distribution of OpenVINO(TM) tookit for Windows*

Components and their licenses:
* Intel(R) Deep Learning Deployment Toolkit
    * Model Optimizer (Apache 2.0): <install_root>/deployment_tools/model_optimizer/*
    * Inference Engine (ISSL): <install_root>/deployment_tools/inference_engine/*
        * Inference Engine Headers (Apache 2.0): <install_root>/deployment_tools/inference_engine/include/*
        * Inference Engine Samples (Apache 2.0): <install_root>/deployment_tools/inference_engine/samples/*
        * GNA library (ISSL): <install_root>/deployment_tools/inference_engine/bin/intel64/<Release|Debug>/gna.dll
        * Intel(R) Movidius(TM) Neural Compute SDK (ISSL):
            <install_root>/deployment_tools/inference_engine/bin/intel64/<Release;Debug>/mvnc/MvNCAPI-ma<version>.mvcmd
    * open_model_zoo (Apache 2.0): <install_root>/deployment_tools/open_model_zoo/*
* OpenCV (BSD): <install_root>/opencv/*

------------------------------------------------------------------------
Intel(R) Distribution of OpenVINO(TM) tookit for Linux*

Components and their licenses:
* Intel(R) Deep Learning Deployment Toolkit
    * Model Optimizer (Apache 2.0): <install_root>/deployment_tools/model_optimizer/*
    * Inference Engine (ISSL): <install_root>/deployment_tools/inference_engine/*
        * Inference Engine Headers (Apache 2.0): <install_root>/deployment_tools/inference_engine/include/*
        * Inference Engine Samples (Apache 2.0): <install_root>/deployment_tools/inference_engine/samples/*
        * GNA library (ISSL): <install_root>/deployment_tools/inference_engine/external/gna/lib/<libgna_api.so;libgna_kernel.so>
        * Intel(R) Movidius(TM) Neural Compute SDK (ISSL):
            <install_root>/deployment_tools/inference_engine/lib/intel64/mvnc/MvNCAPI-ma<version>.mvcmd
    * open_model_zoo (Apache 2.0): <install_root>/deployment_tools/open_model_zoo/*
* OpenCV (BSD): <install_root>/opencv/*

------------------------------------------------------------------------
Intel(R) Distribution of OpenVINO(TM) tookit for macOS*

Components and their licenses:
* Intel(R) Deep Learning Deployment Toolkit
    * Model Optimizer (Apache 2.0): <install_root>/deployment_tools/model_optimizer/*
    * Inference Engine (ISSL): <install_root>/deployment_tools/inference_engine/*
        * Inference Engine Headers (Apache 2.0): <install_root>/deployment_tools/inference_engine/include/*
        * Inference Engine Samples (Apache 2.0): <install_root>/deployment_tools/inference_engine/samples/*
        * Intel(R) Movidius(TM) Neural Compute SDK (ISSL):
            <install_root>/deployment_tools/inference_engine/lib/intel64/mvnc/MvNCAPI-ma<version>.mvcmd
    * open_model_zoo (Apache 2.0): <install_root>/deployment_tools/open_model_zoo/*
* OpenCV (BSD): <install_root>/opencv/*

------------------------------------------------------------------------

Licenses:
 * ISSL: Intel Simplified Software License <install_root>/licensing/deployment_tools/ISSL.txt
 * Apache 2.0 <install_root>/licensing/deployment_tools/Apache_license.txt
 * BSD: License Agreement For Open Source Computer Vision Library (3-clause BSD License) <install_root>/licensing/opencv/BSD_license.txt
 * MIT: The MIT License <install_root>/licensing/install_dependencies/MIT_license.txt

------------------------------------------------------------------------
Third party programs:
* Intel(R) Deep Learning Deployment Toolkit: <install_root>/licensing/deployment_tools/third-party-programs.txt
* OpenCV: <install_root>/opencv/third-party-programs.txt
    * <install_root>/opencv/ffmpeg-download.ps1
        FFMPEG wrappers for Windows are not supplied with the distribution.
        If you need to read and write video files on Windows via FFMPEG, please, download the files using the provided script.
        Note, that these wrappers are subjects to LGPL license. The full source code is available at the same repository on GitHub:
        https://github.com/opencv/opencv_3rdparty/tree/ffmpeg/master_<timestamp>_src
* DL Workbench: <install_root>/licensing/deployment_tools/tools/workbench/docker_image_thirdparty.txt

------------------------------------------------------------------------
Redistributable content:
* Intel(R) Deep Learning Deployment Toolkit: <install_root>/licensing/deployment_tools/redist.txt
* OpenCV: <install_root>/licensing/opencv/redist.txt
* install_dependencies: <install_root>/licensing/install_dependencies/redist.txt
