from gtts import gTTS
import os

tts=gTTS(text='발이 두 개 달린 소는?    이발소     하 하 하 하 하 ', lang='ko')
tts.save("funny.mp3")
