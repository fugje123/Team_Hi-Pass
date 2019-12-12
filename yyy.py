import os
import ser as mmo
mmo.trackingmode()
mmo.cleanup()
os.system("pkill -9 -ef process")
os.system("pkill -9 -ef face_recog")

