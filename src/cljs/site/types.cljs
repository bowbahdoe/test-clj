;; Module for declaring the structure of basic types,
;; as well as any tests to determine type
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

;; |X| X -> Boolean
;; Returns whether a data item is a Sequence
(defn sequence? [possible]
  (or (vector? possible)
      (list? possible)))

;; An N is one of
;; -- 0
;; -- (inc N)

;; |X| X -> Boolean
;; Returns whether a data item is an N
(defn N? [possible-N]
  (and (>= possible-N 0)
       (integer? possible-N)))
