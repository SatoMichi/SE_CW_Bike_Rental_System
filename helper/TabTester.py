from os import listdir

def checkTab(file):
    exist = False
    with open(file,"r") as f:
        for ch in f:
            if "\t" == ch:
                print("\n!!! There is TAB !!!")
                exist = True
            print(ch,end= "")
        return exist

filePath = listdir(".")

for f in filePath:
    do = input("Continue?")
    print("#######################################################################")
    print(f)
    print(checkTab(f))
    print("#######################################################################")




