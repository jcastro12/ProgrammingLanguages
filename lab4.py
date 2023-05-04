# Name: Joshua Castro
# Date: April 6
# CSI 310, Lab 04
# Name data program

# This program reads in a list of names from the names-data.txt file, stores them in a dictionary, and allows the user to query the data in a few different ways.
# User can provide a year to receive the top 10 most popular from that year, provide a name substring to search for (displaying most popular year), or search for a name to see all data attached.

#import for quit
import sys

# method to read the data to a dictionary from the names-data.txt file, returning the dictionary
# param: none
# return: dictionary of name/value pairs
def read_data():
    f = open("names-data.txt")
    num_entries = int(f.readline().strip())
    d = {}
    # loops through each line, adding name and values to dictionary
    for i in range(num_entries):
        line = f.readline().strip().split()
        name = line[0]
        vals = [int(num) for num in line[1:]]
        d[name] = vals
    return d

# method to loop for the menu until 4 is inputted
# param: dictionary d with name/value pairs
# return: none
def menu_loop(d):
    response = 0
    # loops until exit (I don't think the while response!= 4 is even necessary because I exited, but still, it works this way so I'm leaving it)
    while(response!="4"):
        print()
        print("Please select an option:")
        print("(1) Search")
        print("(2) Popularity Over Time")
        print("(3) Top Ten")
        print("(4) Quit")
        response = input("Enter your choice (1-4): ")
        print()
        if response == "1":
            search(d)
        elif response == "2":
            rankings(d)
        elif response == "3":
            t10(d)
        elif response == "4":
            print("Goodbye!")
            sys.exit()
        else:
            print("Invalid choice. Try again.")

# method to search for all names containing user substring, displaying name with most popular year
# param: dictionary d with name/value pairs
# return: none
def search(d):
    name = input("Enter a name to search for: ").lower()
    # search each key in dictionary, checking if key matches
    for key, value in d.items():
        if name in key.lower():
            nonzero = []
            # creates a copy of the value list, replacing 0s with 1000, then printing the index of the lowest value converted to appropriate year
            for num in value:
                if num != 0:
                    nonzero.append(num)
                else:
                    nonzero.append(1000)
            print(key+": "+str(1900+10*nonzero.index(min(nonzero))))

# method to display rankings over time for a specific name
# param: dictionary d with name/value pairs
# return: none
def rankings(d):
        name = input("Enter a name to search for: ").capitalize()
        # searches dictionary for user-entered name, printing data with format if match found
        if name in d:
            print(f"Rankings for \"{name}\":")
            print("1900\t1910\t1920\t1930\t1940\t1950\t1960\t1970\t1980\t1990\t2000\t2010")
            print("---------------------------------------------------------------------------------------------")
            print('\t'.join(str(x) for x in d[name]))
            print()
        else:
            print(f"{name} not found in data.")

# method to display top 10 names for a certain year
# param: dictionary d with name/value pairs
# return: none
def t10(d):
        year = (int)(input("Enter a year to display the 10 most popular values from: "))
        index = (int)((year-1900)/10)
        top10 = {(i+1): [] for i in range(10)}
        # search through all entries for specific year, checking for top 10, putting them into appropriate slot in second dictionary
        for key, value in d.items():
            if value[index]==1:
                top10[1].append(key) 
            elif value[index]==2:
                top10[2].append(key)
            elif value[index]==3:
                top10[3].append(key)             
            elif value[index]==4:
                top10[4].append(key)
            elif value[index]==5:
                top10[5].append(key)
            elif value[index]==6:
                top10[6].append(key)
            elif value[index]==7:
                top10[7].append(key)             
            elif value[index]==8:
                top10[8].append(key)
            elif value[index]==9:
                top10[9].append(key)  
            elif value[index]==10:
                top10[10].append(key)      
        for key, value in top10.items():
            print(f"{key}. {value[0]}, {value[1]}")
        print()

# main method that reads in the data and then starts the menu loop
# param: none
# return: none
def main():
    d = read_data()
    menu_loop(d)

main()