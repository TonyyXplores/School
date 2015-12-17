
Part 1: Simple Function Definitions
1.all-length: so we loop through the list x, check if car x is a list. If it is a list, we
add them by recursive call to all-length (car x) and all-length (cdr x). From here, this will
go to our next condition, which is checking if car x is an atom. If it is, we just simply add 1.

2.range: what we did were creating two helper functions, maximum and minimum, and just called them
in range. For maximum, we just loop through the list and find the min by using the built in function "min" 
then recursively call the function over and over until the list ends. For minimum, it is quite similar
to maximum.

3.before: we created a helper function and just call this helper function in before. This helper function
contains a, b, seen (which is currently set to nil), and the list l. Inside this helper function, we just
loop through the list and see if car l is equal to a. If it is, we append the recursive call that update
seen to true into the list (car l). Now if we see seen equal to true. We going to keep appending the recurseive
call that update a to seen and seen to t into list (car l). So when it sees seen equal to true and car l equal to
b, it will report the current list that contain all the element from a through b.

4.split-if: we used remove-if and remove-if-not to just simply take in the lambda function and used it information
to modify the given list.

5.group: we created a helper function and call this helper function in group. This helper function contains list l, 
trim (which currently set to nil), and the number n. Inside this helper function, We checked if the length of trim is
equal to n then we going to print out the group and recursely call the helper function with the trim reset back to nil.     
Else, we just going to append list (car l) into trim recursively.

6.mostn: we also have a helper function, and mostn just going to list out the result from this helper function and 
the funcall of function f of car of the helper function. Our helper function contains function f, list l, element (currently set to nil), 
and myLength (currently equal to zero). So we going to loop through the list, check if funcall of f (Car l) is greater than myLength.
If it is, then we recursively call the helper function and update element to list (car l) and length to funcall f (car l).
If funcall f (car l) is equal to myLength. We just simply append list (car l) to element and recursively call the function with the update
information of element. Else, to keep going. 

7.match: We loop through two lists and comparing them at when the list ends. During the looping, we check to see if car x = ?. If it is, we keep
on moving to the next element. Then we check if car x = ! and the next element is not nil, then we return true. if car x just equal !, we just keep
moving to the next one but this means that list x has ended, so in the recursive call we need to pass in x instead of cdr x. Else, check to see if 
car x equal to car y and keep moving.


8.match-var: we created a check function to unbound the item in both lists x and y. Then we also create a helper function that take in these newly x and
y list. In the helper function, similar to match, we going to loop through both lists and compare them. We check if car x is a list and caar x equal to ?,
if it is then we going to set cadar x to car y. If car x is a list and caar x equal to !, we going to see if the cadar x is bound. If it is not, we going to set 
cadar x to list (car y). Then check if the evaluation of cadar x is a list. If it is, we going to set cadar x by appending list (car y) into the eval (cadar x).
Else return true. For the case that x list ends early and it equal to !, just update the x by replacing cdr x with just x. 
