;; Utilitities used more than once
(ns site.general)

;; ----------------------------------------------------------------------------
;; |Sequence X| -> |Vector (list N X)|
;; Returns a Vector of the elements of collection paired in a list with their
;; original index in collection
;; Ex.
;; [] -> []
;; '() -> []
;; '(a) -> ['(0 a)]
;; ['a] -> ['(0 a)]
;; '(a b c) -> ['(0 a) '(1 b) '(2 c)]
;; ['a 'b 'c] -> ['(0 a) '(1 b) '(2 c)]

(defn enumerate [collection]
  (loop [col collection
         new-col []
         N 0]
    (if (empty? col)
      new-col
      (recur (rest col) (conj new-col (list N (first col))) (inc N)))))
