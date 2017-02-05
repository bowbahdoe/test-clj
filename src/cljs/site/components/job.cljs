(ns site.components.job
  (:require [cljs-react-material-ui.reagent :as ui]
            [re-frame.core :refer [subscribe dispatch]]))

;; ----------------------------------------------------------------------------
(def styles {
  :container {
    :padding "10px",
    :margin "10px 10px 0 10px",
    :position "relative"
  },
  :person {
    :border "solid",
    :borderWidth "1px",
    :borderRadius "3px",
    :padding "10px",
    :display "inline-block",
    :marginTop "10px"
  },
  :project-name {
    :fontSize "30px"
  },
  :edit {
    :position "absolute",
    :right "10px",
    :top "10px"
  },
  :status {
    :position "absolute",
    :right "10px",
    :bottom "10px",
    :fontSize "20px",
    :fontWeight "bold"
  }
})

;; ----------------------------------------------------------------------------
;; Job -> HTML
;; renders the given job as a card to be placed on a larger view
(defn job-panel
  [{:keys [name status project-name email-address phone-number]}]
    [:div {:class "row around-xs"}
      [:div {:class "col-xs-12 col-lg-8"}
        [ui/paper {:zDepth 1 :style (:container styles)}
          [ui/raised-button {:label "EDIT" :primary true :style (:edit styles)}]
          [:div {:style (:project-name styles)} project-name]
          [:div {:style (:person styles)}
            [:div name]
            [:div email-address]
            [:div phone-number]]
          [:div {:style (:status styles)} status]]]])

;; ----------------------------------------------------------------------------
;; _, _, (str JobCategory) -> nil
;; Takes in the parameters passed by :onChange and dispatches the value
;; of the call as the new job category
(defn- set-job-category [_ _ category]
  (dispatch [:jobs/set-job-category (symbol category)]))

;; ----------------------------------------------------------------------------
;; nil -> HTML
;; renders the dropdown menu that filters the currently viewed job type
(defn- job-type-dropdown []
  [ui/drop-down-menu
    {:value @(subscribe [:job-category])
     :onChange set-job-category}
     [ui/menu-item {:value 'ALL :primaryText 'ALL}]
     [ui/menu-item {:value 'PRINTING :primaryText 'PRINTING}]
     [ui/menu-item {:value 'COMPLETED :primaryText 'COMPLETED}]
     [ui/menu-item {:value 'PROBLEM :primaryText 'PROBLEM}]
     [ui/menu-item {:value 'CLOSED :primaryText 'CLOSED}]])

;; ----------------------------------------------------------------------------
(defn job-view []
  [:div
    [ui/toolbar
      [ui/toolbar-group
        [ui/toolbar-title {:text
                            (str "Showing "
                                 @(subscribe [:job-category])
                                 " Jobs")}]]
      [ui/toolbar-group
        [job-type-dropdown]
        [ui/toolbar-separator]
        [ui/raised-button {:label "Create Job" :primary true}]]]
    [:div
      [job-panel {:_id 'String
                  :name "Dirk Action",
                  :status "Printing",
                  :project-name "Twelve Blue Yoshis",
                  :email-address "freak@freaky.freak",
                  :phone-number "555-555-5555"}]]])
