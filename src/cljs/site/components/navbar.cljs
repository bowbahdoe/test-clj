(ns site.components.navbar
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [site.general :refer [enumerate]]
              [cljs-css-modules.macro :refer-macros [defstyle]]))

;; ----------------------------------------------------------------------------
;; An Alignment is one of
;; -- 'left
;; -- 'right

;; ----------------------------------------------------------------------------
;; A Nav-Button-Description is a
;; -- {:title String
;;:    :link String
;;     :align Alignment}

;; ----------------------------------------------------------------------------
;; A Dropdown-Link-Description is a
;; -- {:title String
;;     :link String}

;; ----------------------------------------------------------------------------
;; A Nav-Dropdown-Description is a
;; -- {:title String
;;     :align Alignment
;;     :contents |Sequence Dropdown-Link-Description|

;; ----------------------------------------------------------------------------
;; A Nav-Description one of
;; -- Nav-Button-Description
;; -- Nav-Dropdown-Description

;; where :title is the Text that will appear on that nav-button
;; and :link is the href to which that nav points
;; :align says where on the navbar the element appears

;; ----------------------------------------------------------------------------
(def hover-color "red")
(defstyle navbar-style
  [".nav"
    ["ul" {:list-style-type "none"
           :margin 0
           :padding 0
           :overflow "hidden"
           :background-color "#333"}]
    ["li" {:float "left"}]
    ["li a" {:display "inline-block"
             :color "white"
             :text-align "center"
             :padding "14px 16px"
             :text-decoration "none"}]
    [".dropbtn"
        {:display "inline-block"
         :color "white"
         :text-align "center"
         :padding "14px 16px"
         :text-decoration "none"}]
    ["li a:hover" {:background-color hover-color}]
    [".dropdown:hover .dropbtn" {:background-color hover-color}]
    ["li.dropbtn" {:display "inline-block"}]
    ["li.dropbtn" {:display "inline-block"}]
    [".dropdown-content"
      {:display "none"
       :position "absolute"
       :background-color "#f9f9f9"
       :min-width "160px"
       :box-shadow "0px 8px 16px 0px rgba(0,0,0,0.2)"}]
    [".dropdown-content a"
      {:color "black"
       :padding "12px 16px"
       :text-decoration "none"
       :display "block"
       :text-align "left"}]
    [".dropdown-content a:hover"
      {:background-color "#f1f1f1"}]
    [".dropdown:hover .dropdown-content" {:display "block"}]])

;; |Sequence Nav-Description| -> |Sequence Nav-Description|
;; Sorts the given sequence of Nav-Descriptions by left and right
;; alignment. Preserves relative order of left and right aligned
;; descriptions
(defn sort-by-alignment [descriptions]
  (concat (filter #(= 'left (:align %)) descriptions)
          (filter #(= 'right (:align %)) descriptions)))

;; ----------------------------------------------------------------------------
;; Nav-Description -> Boolean
;; returns whether a given nav-description is a dropdown
(defn dropdown? [nav-description]
  (not (= nil (:contents nav-description))))

;; ----------------------------------------------------------------------------
;; Nav-Button-Description -> HTML
;; Renders the given description of a nav button as HTML
(defn render-button [button-desc]
  (if (= (:align button-desc) 'right)
    [:li {:style {:float "right"}}
      [:a {:href (:link button-desc)}
          (:title button-desc)]]
    [:li {:style {:float "left"}}
      [:a {:href (:link button-desc)}
          (:title button-desc)]]))

;; ----------------------------------------------------------------------------
;; Nav-Dropdown-Description -> HTML
;; renders the given Nav-Dropdown-Description to HTML
(defn render-dropdown [dropdown-desc]
  (if (= (:align dropdown-desc) 'right)
    [:li {:class "dropdown" :style {:float "right"}}
      [:div {:class "dropbtn"}
        'Dropdown
        [:div {:class "dropdown-content"}
          [:a {:href "#"} "Link 1"]]]]
    [:li {:class "dropdown" :style {:float "right"}}
      [:a {:href "javascript:void(0)" :class "dropbtn"}
        'Dropdown
        [:div {:class "dropdown-content"}
          [:a {:href "#"} "Link 1"]]]]))

;; ----------------------------------------------------------------------------
;; Nav-Description -> HTML
;; Renders the given Nav-Description
(defn render-nav-element [nav-description]
  (if (dropdown? nav-description)
    (render-dropdown nav-description)
    (render-button nav-description)))

;; ----------------------------------------------------------------------------
;; & Nav-Description -> HTML
;; Renders the descriptions as HTML.
;; N.B. Descriptions with an :align of 'right are shuffled to
;; the right on the arguments list of those with an :align
;; of 'left in the rendering
(defn navbar [& descs]
  [:div {:class-name (:nav navbar-style)}
    [:ul
      (for [[index des] (enumerate (sort-by-alignment descs))]
        (with-meta (render-nav-element des) {:key index}))]])
