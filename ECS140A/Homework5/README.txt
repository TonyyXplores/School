Part one
Part one was quite stright forward, for fc_course we used the basic logic that we want courses with only 4 or 3 units. If X is in the course, return the units and it has to be (4 or 3), (UNITS =3 ; UNITS =4).
We used this same logical method for the rest of part one.i Also using the built in functions such as member() to check if there the given input is a member of the given data. We also used the member function to compare two list. ( member(X,L1) member(X,L2) ). Once we finished testing our queries and the predicates were correctly named we then tested our program with the provided test shell.

Part two
1. For the all_length predicate, we first started with the base case and then moved on from there. 
The base case being the empty set, the next one being the a set that only contained a set of atoms, then another that worked with sets which in sets. This was also pretty stright forward. Base case, then check if head is an atom and/or a list set and recursive call from there. 

2. For the part it was a bit more challenging. We made a seperate check predicate that does what its name states. Checks. Our check function contains the list given, with two initial counters set to 0. the check function then does a simple check if the Head is either a or b and if not move on, if a is found then its respective counter gets incremented, if b is found then its respective counter is incremented. Then recursive call with T and updated counters. 

3.The thought process was to split the given the given L and place the sub list between them. So we defined a predicate to appendin so that L can be created by appending.

4.For this one we got the list sent it to another predicate that has a base case, two empty sets, then move on to create another the reversed list. then if both the L and the reverse are equal then it must be a palin. 

5.Here we had defined the good predicate as if it is a single [0] then its good, else it has to start with a 1 followed by a 0. we did that by using [1|T] where we check if the T follows the rule. We do this by using append like for example append(L1,L2 [1,0,1,0,0]) this sets L2 to the given set and move it to L1 one by one, and we check if weather its a 0 singleton. or 1 followed by a 0. 

part three

part three works great and seems to be function the way it is supposed to. It was a bit difficult, but using the hints 
helped out a good amount.
part three results:
take(Goat, left, right).
take(None, right, left).
take(Cabbage, left, right).
take(Goat, right, left).
take(Wolf, left, right).
take(None, right, left).
take(Goat, left, right).

take(Goat, left, right).
take(None, right, left).
take(Wolf, left, right).
take(Goat, right, left).
take(Cabbage, left, right).
take(None, right, left).
take(Goat, left, right).



