#!/bin/bash
source ~/OpenVINO/bin/setupvars.sh
source /usr/local/bin/virtualenvwrapper.sh
sudo service motion stop
workon cv
cd ~/Hi-Pass/face_recognition
python3 face_recog.py $
deactivate cv
