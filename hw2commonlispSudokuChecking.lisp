;gnu clisp 2.49
(setf sudokudigits '((1 2 3 4 5 6 7 8 9) ( 4 5 6 7 8 9 1 2 3) (7 8 9 1 2 3 4 5 6) 
                (5 6 7 8 9 1 2 3 4) (8 9 1 2 3 4 5 6 7) (2 3 4 5 6 7 8 9 1) 
                (3 4 5 6 7 8 9 1 2) (6 7 8 9 1 2 3 4 5) (9 1 2 3 4 5 6 7 8)))

(setf ninedigits '(1 2 3 4 5 6 7 8 9))

; check whether each ROW contains 9 different number
(loop for x from 0 to 8 do
          (let ((curdigits (nth x sudokudigits)))
             (if (endp (set-difference ninedigits curdigits)) 
              ; if current row contains 9 different digits, therefore two sets ninedigits and curdigits contain same numbers
              (print (format nil "Row ~D GOOD." (+ x 1)))
              ; else 
              (print (format nil "Not A Sudoku Solution. Row ~D does not contain nine different numbers" (+ x 1))))))

; TODO: check whether each COLUMN contains 9 different numbers; 
; if a row R contains nine different digits,
; print Row R is good. 
; else print Not A Sudoku solution. Row R does not contain nine different digits

; hint - get nine numbers from each column and check whether it is 9 digits
; lambda function - for each element in sudokudigits, get its third element
(setf thirdcoldigits (mapcar #'(lambda (x) (nth 2 x)) sudokudigits))
(print thirdcoldigits)

; TODO: check whether each Box contains 9 different numbers; 
; if a box contains nine different digits,
; print Box B is good. 
; else print Not A Sudoku solution. Box B does not contain nine different digits
; hint - get nine numbers for each box, and compare it with ninedigits 
(defun getSudokuDigits (rows cols)
    (let ((digits nil))
        (loop for x in rows do
          (loop for y in cols do 
           (push (nth y (nth x sudokudigits)) digits)))
         digits))

; the following will get the first box's digits
(print (getSudokuDigits '(0 1 2) '(0 1 2)))

; the following will get the second box's digits
(print (getSudokuDigits '(0 1 2) '(3 4 5)))
                                       
