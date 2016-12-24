(ns site.components.navbar-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [site.components.navbar :as nav]))

;; ----------------------------------------------------------------------------
;; Constants

(def ex-description-1
  {:title "Title 1"
   :link "link 1"
   :align 'left})

(def ex-description-2
  {:title "Title 2"
   :link "link 2"
   :align 'right})

(def ex-description-3
  {:title "Title 3"
   :align 'left
   :contents [{:title "some link"
               :link "/about"}
               {:title "some other link"
                :link "/page"}]})

(def ex-description-4
  {:title "Title 4"
   :align 'right
   :contents [{:title "some link"
               :link "/about"}]})

(def ex-description-5
  {:title "Title 5"
   :align 'right
   :contents []})

(def ex-description-6
  {:title "Title 6"
   :align 'left
   :contents []})

;; ----------------------------------------------------------------------------
(deftest sort-by-alignment-test
  (testing "site.components.navbar/sort-by-alignment"
    (is (= (nav/sort-by-alignment []) []))
    (is (= (nav/sort-by-alignment '()) '()))
    (is (= (nav/sort-by-alignment [ex-description-1 ex-description-2])
           [ex-description-1 ex-description-2]))
    (is (= (nav/sort-by-alignment [ex-description-2 ex-description-1])
            [ex-description-1 ex-description-2]))
    (is (= (nav/sort-by-alignment [ex-description-1
                                   ex-description-2
                                   ex-description-3
                                   ex-description-4
                                   ex-description-5
                                   ex-description-6])
            [ex-description-1
             ex-description-3
             ex-description-6
             ex-description-2
             ex-description-4
             ex-description-5]))
    (is (= (nav/sort-by-alignment [ex-description-4
                                   ex-description-2
                                   ex-description-3
                                   ex-description-4
                                   ex-description-4
                                   ex-description-6])
            [ex-description-3
             ex-description-6
             ex-description-4
             ex-description-2
             ex-description-4
             ex-description-4]))))

;; ----------------------------------------------------------------------------
(deftest dropdown?-test
  (testing "site.components.navbar/dropdown?"
    (is (not (nav/dropdown? ex-description-1)))
    (is (not (nav/dropdown? ex-description-2)))
    (is (nav/dropdown? ex-description-3))
    (is (nav/dropdown? ex-description-4))
    (is (nav/dropdown? ex-description-5))
    (is (nav/dropdown? ex-description-6))))

;; ----------------------------------------------------------------------------
(deftest render-nav-element-test
  (testing "site.components.navbar/dropdown?"
    (is (nav/render-nav-element ex-description-1)
        (nav/render-button ex-description-1))
    (is (nav/render-nav-element ex-description-2)
        (nav/render-button ex-description-2))
    (is (nav/render-nav-element ex-description-3)
        (nav/render-dropdown ex-description-3))
    (is (nav/render-nav-element ex-description-4)
        (nav/render-dropdown ex-description-4))
    (is (nav/render-nav-element ex-description-5)
        (nav/render-dropdown ex-description-5))
    (is (nav/render-nav-element ex-description-5)
        (nav/render-dropdown ex-description-5))))
