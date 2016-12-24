(ns site.types-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [site.types :as t]))

(deftest sequence?-test
  (testing "site.types/sequence?"
    (is (t/sequence? []))
    (is (t/sequence? '()))
    (is (t/sequence? [1 2]))
    (is (t/sequence? '(1 2)))
    (is (t/sequence? '(a b :c)))
    (is (t/sequence? ['arbitrary 0 "data"])
    (is (not (t/sequence? "hi"))
    (is (not (t/sequence? {:maps :are :not :sequences})))))))

(deftest N?-test
  (testing "site.types/N?"
    (is (t/N? 0))
    (is (t/N? 1))
    (is (t/N? 100))
    (is (not (t/N? -1)))
    (is (not (t/N? 1.3)))
    (is (not (t/N? -100.1)))
    (is (not (t/N? "hello")))
    (is (not (t/N? ['not 'an 'N])))))
