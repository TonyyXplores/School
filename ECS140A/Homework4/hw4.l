(defun all-length (x)
	(cond
		((null x) 0)
		((listp (car x)) (+ (all-length (car x))(all-length (cdr x))))
		((atom (car x)) (+ 1 (all-length (cdr x))))
	)
)

(defun minimum (x)
	(cond
		((null (cdr x)) (car x))
		(t (min (car x) (minimum (cdr x))))
	)
)

(defun maximum (x)
	(cond
		((null (cdr x)) (car x))
		(t (max (car x) (maximum (cdr x))))
	)
)

(defun range (x)
	(list (minimum x) (maximum x))
)

(defun before (a b l)
	(after a b nil l)
)


(defun after (a b seen l)
	(cond
		((null l) nil)
		((and (equal seen t)(equal (car l) b)) (list (car l)))
		((equal seen t)  (append (list (car l)) (after seen b t (cdr l))))
		((equal (car l) a) (append (list (car l)) (after a b t (cdr l))))
		(t (after a b seen (cdr l)))
	)
)

(defun split-if(f l)
	(list (remove-if f l) (remove-if-not f l))
)

(defun group (l n)
	(cond
		((null l) nil)
		((group_help l nil n))
		(t nil)
	)
)


(defun group_help (l trim n)
	(cond
		((null l) (list trim))
		((equal (length trim) n) (cons trim (group_help l nil n)))
		(t (group_help (cdr l) (append trim (list(car l))) n))
	)
)

(defun mostn (f l)
	(list (mostn_help f l nil 0) (funcall f (car(mostn_help f l nil 0))))
)

(defun mostn_help (f l element myLength)
	(cond
		((null l) element)
		((> (funcall f (car l)) myLength) (mostn_help f (cdr l) (setf element (list (car l))) (funcall f (car l))))
		((equal (funcall f (car l)) myLength) (and (append element (list(car l))) (mostn_help f (cdr l) (append element (list (car l))) myLength)))
		(t (mostn_help f (cdr l) element myLength))
	)
)

(defun match (x y)
	(cond 
		((or (null x) (null y)) (equal x y))
		((equal (car x) '?) (match (cdr x) (cdr y)))
		((and (equal (car x) '!) (match (cdr x) (cdr y))) t)
		((equal (car x) '!) (match x (cdr y)))
		(t (and (equal (car x) (car y)) (match (cdr x) (cdr y))))
	)
)
		
(defun check (x)
	(cond
		((null x) nil)
		((null (car x)) (check (cdr x)))
		((and (listp (car x)) (makunbound (cadar x)))  (check (cdr x)))
		((numberp (car x)) nil)
		((atom (car x)) (makunbound (car x)) (check (cdr x)))
		(t t)
	)
)


(defun match-var-help (x y)
	(cond
		((or (null x)(null y)) (equal x y))
		((and (listp (car x)) (equal (caar x) '?)) (set (cadar x)(car y))(match-var-help (cdr x)(cdr y)))
		((and (and (listp (car x)) (equal (caar x) '!))
      			(cond
        			((not (boundp (cadar x))) (set (cadar x) (list(car y))))
        			((listp (eval (cadar x))) (set (cadar x) (append (eval (cadar x)) (list(car y)))))      
					(t t)
      			)
      			(match-var-help (cdr x) (cdr y))) t)  
		((and (listp (car x)) (equal (caar x) '!)) (match-var-help x (cdr y)))  
		(t (and (equal (car x)(car y))(match-var-help (cdr x)(cdr y))))
	)
)


(defun match-var (x y)
	(check x)
	(check y)
	(match-var-help x y)
)
