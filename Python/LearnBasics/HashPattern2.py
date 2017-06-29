'''
This program takes input a even number n. Then it prints n line in the following pattern
For n = 8
   ##
  ####
 ######
########
########
 ######
  ####
   ##
'''
n=input("Enter number of lines in patter (should be even): ")
for i in range(1,n/2+1):
    print (' ' * (n/2-i)) + ('##' * i)

for i in range(1,n/2+1):
    print (' ' * (i-1)) + ('##' * (n/2-i+1))

