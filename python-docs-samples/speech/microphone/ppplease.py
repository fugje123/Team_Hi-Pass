import nltk

import os
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.stem import WordNetLemmatizer
from nltk.stem import PorterStemmer, LancasterStemmer

st1 = PorterStemmer()
st2 = LancasterStemmer()
 
n = WordNetLemmatizer()

#nlp code
stopwords.words('english')[:10]
result = []
f=open("/home/pi/Hi-Pass/python-docs-samples/speech/microphone/results.txt", "r")
line = f.readline()
f.close()
speech = line
stop_words = set(stopwords.words('english'))
word_tokens = word_tokenize(speech)
for x in word_tokens:
  if x not in stop_words:
    result.append(x)

results_file = open("/home/pi/Hi-Pass/python-docs-samples/speech/microphone/nlp_result.txt","w")
result_string = [st2.stem(w) for w in result]
print(word_tokens)
print("Lancaster Stemmer:", [st2.stem(w) for w in result])

results_file.write(' '.join(result_string))
results_file.close()
os.system("python /home/pi/Hi-Pass/python-docs-samples/speech/microphone/role_activate.py")
exit()
