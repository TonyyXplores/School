Part 1: For part 1, we just simply defined four different classes, Element, MyChar, MyInteger, and Sequence.

Part 2: For part 2, we implemented 5 new functions for the Sequence class. We first created a constructor for
Sequence, which will just set its variable to null. 
*first() and rest() function, we just simply respectively returned an element and a sequence. 

*length(), we checked whether if the next sequence is null or not. If not, we increment a counter and made the
current sequence equals to the next one, then returned the counter. 

*add(), we created a new object for Sequence and check for position. If pos == 0, we set the next sequence equal 
to the current, the adding element equal to the current element. Else, we just set the adding element equal to 
current one. Then created a for loop and set the current sequence equal to the next one and keep adding them in.


Part 3: For part 3, we implemented 3 new functions for the Sequence class
*index(), we checked for the position, if the position is less than 0 or greater than the length of the sequence,
we returned an error and exit. Else, we set current sequence equal to the next one in a for loop then return the
current element.

*flatten(), we created a new object of Sequence and another object sequence and equated it to current sequence. 
The we check if the current element is an instance of sequence then we add it. Else, just add it and set current 
equals to the next one.

*copy(), the procedure is a bit similar to flatten, except that we have to checked if it is an instance of Sequence/
MyChar/MyInteger, and then set and add it. 

Part 4: For part 4, we have to construct another class call SequenceIterator that will handle the begin() and end()
Inside the class SequenceIterator, we will have 3 functions:
*equal(), we simply check to see if the current value is equal to the passed in value then just returned true or false.

*advance(), we check if the next sequence is not null then we made the current value that the iterator hold equals to the next
one.

*get(), we simply just return the current element.
Inside the class Sequence, we will have 2 new functions:
*begin(), we just simply created a new object of SequenceIterator and copy the current sequence to it and return.

*end(), similar to begin, created an object of SequenceIterator and copy the current sequence to it. Then check if the next sequence null or not.
if not, set the current iterator equal to the next one then return.

Part 5 : For part 5, we have to construct a Matrix class, which is an extends of Sequence. This Matrix class will have its own print, and a 
constructor along with 4 functions:
*Set(), we just simply set the value for given row and col

*Get(), we just simply get the value for given row and col

*Sum(), we loop thourgh the matrix and add up the value by using Get(), and then using Set() to set the sum.

*Product(), we did something similar to how we did sum.

part 6 : For part 6, we have to construct a Map class, which is an extends of Sequence. Also a Pair class, an extends of Element, and finally
a MapIterator class, and extends from SequenceIterator. 
Inside the Pair class, we will have a constructor and its print(). The constructor is there to just simply set the value to the current one. 

Inside the MapIterator class, we will cover everything that the SequenceIterator supported.So the method are very similar.

Inside the Map class, the begin() and end() are implemented the same way as in Sequence. Only the add() and find() are new in map.
*add(), the way of adding is quite similar to the Sequence add(), however, we sorted the map before adding stuff to it.

*find(), we just check to see if the the key.Get() equals to our current.p.c.Get() then we just return it.
