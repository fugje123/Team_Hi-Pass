filename = '/home/pi/Hi-Pass/python-docs-samples/speech/microphone/results.txt'
with open(filename) as data:
    lines = data.readlines()
    
numbers=[]
for line in lines:
    numbers.append(line.split(' '))
splits=line.split(' ')[-1]
print(splits)

f = open("/home/pi/Hi-Pass/python-docs-samples/speech/microphone/laststr.txt","w")
f.write(splits)
f.close
