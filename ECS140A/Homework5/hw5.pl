/*******************************************/
/**    Your solution goes in this file    **/ 
/*******************************************/
%PART 1

%a
fc_course(X) :- course(X,_,U), (U = 3; U = 4).

%b
prereq_110(X) :- course(X,R,_), member(ecs110,R).

%c
ecs140a_students(N) :- student(N, X), member(ecs140a, X).

%d
teachj(X) :-instructor(X, Y), student(john, SC), member(M,Y ), member(M,SC), !.
instructor_names(X) :- instructor(X, _), teachj(X). %student(John, SC), member(M, Y), member(M,SC), !.
%e
inclass(X) :- student(X,Y), instructor(jim,I), member(E,Y), member(E,I), !.
students(X) :- student(X,_), inclass(X). %instructor(jim,G), member(E,Y), member(E,G), !.
%f

allprereq(C,Pre) :- findall(X, ( course(X,_,_), prereq(C,X) ), Pre).
prereq(C, X) :- course(C,CLASSI,_) , (member(X,CLASSI); member(S,CLASSI), prereq(S,X)).

%part 2
all_length([],0).
all_length([H|T],Len) :- atom(H), all_length(T,LenT), Len is LenT + 1, !.
all_length([H|T],Len) :- list(H), all_length(H,LenH), all_length(T,LenT), Len is LenT + LenH, !.

check([],A,A).
check([H|T],A,B):- H \= a, H\=b, check(T,A,B),!.
check([H|T],A,B):- H == a, A1 is A + 1, check(T,A1,B),!.
check([H|T],A,B):- H == b, B1 is B + 1, check(T,A,B1),!.
equal_a_b(L):- check(L,0,0).

swap_prefix_suffix(K,L,S):- my_append(L1,K,L3,L), my_append(L3,K,L1,S).
my_append(L1,L2,L3,L):- append(L1,LL,L), append(L2,L3,LL).

my_reverse([],[]).
my_reverse([H|T],L):- my_reverse(T,R), append(R,[H],L).
palin(L):- my_reverse(L,R), L == R.

good([0]).
good([1|L]):- append(X,Y,L), good(X), good(Y).


%part3
solve:- go(state(left,left,left,left),state(right,right,right,right)).
go(state(left,left,left,left),state(right,right,right,right)):- pass_through(state(left,left,left,left),[]).

mynot(A):- A, !,fail.
mynot(_).

opposite(left,right).
opposite(right,left).

unsafe(left,right,right,_).
unsafe(right,left,left,_).
unsafe(left,_,right,right).
unsafe(right,_,left,left).

pass_through(state(right,right,right,right),_).

pass_through(state(F,F,G,C),L):- opposite(F,F1), opposite(F,W), mynot(unsafe(F1,W,G,C)), mynot(member(state(F1,W,G,C),L)), pass_through(state(F1,W,G,C),[state(F,F,G,C)|L]), write('take(Wolf, '), write(F), write(', '), write(F1), write(').'),nl.

pass_through(state(F,W,F,C),L):- opposite(F,F1), opposite(F,G1), mynot(unsafe(F1, W, G1, C)), mynot(member(state(F1,W,G1,C),L)), pass_through(state(F1,W,G1,C), [state(F,W,F,C)|L]), write('take(Goat, '), write(F), write(', '), write(F1), write(').'), nl.

pass_through(state(F,W,G,F),L):- opposite(F,F1), opposite(F,C1), mynot(unsafe(F1,W,G,C1)), mynot(member(state(F1,W,G,C1),L)), pass_through(state(F1,W,G,C1),[state(F,W,G,F)|L]), write('take(Cabbage, '), write(F), write(', '), write(F1), write(').'), nl.

pass_through(state(F,W,G,C),L):- opposite(F,F1), mynot(unsafe(F1,W,G,C)), mynot(member(state(F1,W,G,C),L)), pass_through(state(F1,W,G,C), [state(F,W,G,C)|L]), write('take(None, '), write(F), write(', '), write(F1), write(').'), nl.

