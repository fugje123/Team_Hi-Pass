from gtts import gTTS
import os

tts=gTTS(text='자가용 의 반댓말은?      커용 하 하 하 ', lang='ko')
tts.save("funny4.mp3")

