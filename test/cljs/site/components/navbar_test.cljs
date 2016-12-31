(ns site.components.navbar-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [site.components.navbar :as nav]))

;; ----------------------------------------------------------------------------
;; Constants

(def ex-description-1
  {:title "Title 1"
   :link "link 1"})

(def ex-description-2
  {:title "Title 2"
   :link "link 2"})

(def ex-description-3
  {:title "Title 3"
   :contents [{:title "some link"
               :link "/about"}
               {:title "some other link"
                :link "/page"}]})

(def ex-description-4
  {:title "Title 4"
   :contents [{:title "some link"
               :link "/about"}]})

(def ex-description-5
  {:title "Title 5"
   :contents []})

(def ex-description-6
  {:title "Title 6"
   :contents []})


(def ex-description-7
  {:title "Title 7"
   :contents [ex-description-2
              ex-description-6]})


;; ----------------------------------------------------------------------------
(deftest dropdown?-test
  (testing "site.components.navbar/dropdown?"
    (is (not (nav/dropdown? ex-description-1)))
    (is (not (nav/dropdown? ex-description-2)))
    (is (nav/dropdown? ex-description-3))
    (is (nav/dropdown? ex-description-4))
    (is (nav/dropdown? ex-description-5))
    (is (nav/dropdown? ex-description-6))
    (is (nav/dropdown? ex-description-7))))

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
        (nav/render-dropdown ex-description-5))
    (is (nav/render-nav-element ex-description-7)
        (nav/render-dropdown ex-description-7))))
