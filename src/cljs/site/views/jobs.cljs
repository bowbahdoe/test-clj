(ns site.views.jobs
  (:require [site.views.root :refer [main-panel]]
            [site.components.job :refer [job-view]]))

(defmethod main-panel 'jobs []
  [job-view])
