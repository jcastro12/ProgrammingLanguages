;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname DrRacketPair) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
; 1
(define (aMember? atm lst)
  (cond
    ((null? lst) #f)
    ((equal? atm (car lst)) #t)             
    (else (aMember? atm (cdr lst)))))        

(aMember? 1 '(1 2 3 4))
(aMember? 'a '(a b c d))
(aMember? 'e '(a b c d))

; 2
(define (countsimp atm lst)
  (cond
    ((null? lst) 0)
    ((equal? atm (car lst))
     (+ 1 (countsimp atm (cdr lst))))   
    (else (countsimp atm (cdr lst)))
   )
)

(countsimp 'a '(a b c d a b a b))
(countsimp 'e '(a b c d a b a b))

; 3
(define (intersection list1 list2)
  (cond
    ((null? list1) '())
    ((aMember? (car list1) list2) (cons (car list1) (intersection (cdr list1) list2)))
    (else (intersection (cdr list1) list2))
    )
  )

(intersection '(3 4) '(3 4 5 6))


; 4
(define (count atm lst)
  (cond
    ((empty? lst) 0)
    ((list? (car lst)) (+ (count atm (car lst)) (count atm (cdr lst))))
    ((eq? (car lst) atm) (+ 1 (count atm (cdr lst))))
    [else (count atm (cdr lst))]
   )
  )

(count 'a '(a b c a))

; 5
(define (allequal? lst)
  (cond
    ((empty? lst) #t)
    ((equal? (cdr lst) '()) #t)
    ((equal? (car lst) (car (cdr lst))) (allequal? (cdr lst)))
    (else #f)
    )
  )

(allequal? '((1 1) (1 1 2) (1 1)))

;6
(define (mappairs f lst)
  (cond
    ((empty? lst) '())
    ((empty? (cdr lst)) '())
    (else
     (cons (f (car lst) (car (cdr lst)))
           (mappairs f (cdr (cdr lst)))))
    )
  )

(mappairs > '(1 2 2 1 2 2))
