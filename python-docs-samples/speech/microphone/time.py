from datetime import datetime
from gtts import gTTS
now = datetime.now()
tts = gTTS(text=str(now.year)+' 년' + str(now.month) + ' 월' + str(now.day)+' 일' + str(now.hour)+' 시' + str(now.minute) + ' 분 입니다' ,lang='ko')
tts.save("time.mp3")



