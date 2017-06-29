'''
This program takes input a number n. Then it prints n line in the following pattern
For n = 4
########
 ######
  ####
   ##
'''
n=input("Enter number of lines in the pattern: ")
for i in range(0,n):
        print (' ' * i) + ("##" * (n-i))


