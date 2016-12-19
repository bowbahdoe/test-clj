;; Module for declaring the structure of basic types
(ns site.types)

;; |X| A |Vector X| is one of
;; -- []
;; -- (conj X |Vector X|)

;; |X| A |List-of X| is one of
;; -- '()
;; -- (cons X |List-of X|)

;; |X Y| A |Mapping X Y| is one of
;; -- {}
;; -- (assoc |Mapping X Y| X Y)

;; |X| A |Set X| is one of
;; -- #{}
;; -- (conj X |Set X|)

;; |X Y| A |Union X Y| is one of
;; -- X
;; -- Y

;; |X| A |Sequence X| is a |Union |List-of X| |Vector X||

;; An N is one of
;; -- 0
;; -- (inc N)
