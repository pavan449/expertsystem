(defclass PHSpecificaion com.rit.ai.jess.PHSpecificaion)
(defclass ConducSpecification com.rit.ai.jess.ConducSpecification)
(defclass OxySpecification com.rit.ai.jess.OxySpecification)
(defclass SalSpecification com.rit.ai.jess.SalSpecification)
(defclass TempSpecification com.rit.ai.jess.TempSpecification)


(defrule check_threshold_val_ROC_PHSPEC
    
    (PHSpecificaion (rateOfChange ?roc) (thresholdForROC ?troc) (weightForROC ?wroc) (OBJECT ?PHSpecificaion))
    (test (> ?roc ?troc))
    =>
      (set ?PHSpecificaion weightForROC(- ?wroc 0.4))
    	(printout t ?wroc "to " (get ?PHSpecificaion weightForROC) crlf ))


(defrule check_threshold_val_CAL_PHSPEC 
    
    (PHSpecificaion (timeCalibrationMiliSecond ?tcm) (thresholdForCAL ?tcal) (weightForCAL ?wcal) (OBJECT ?PHSpecificaion))
    (test (> ?tcm ?tcal))
    =>
      (set ?PHSpecificaion weightForCAL(- ?wcal 0.3))
    	(printout t ?wcal "to" (get ?PHSpecificaion weightForCAL) crlf))


(defrule check_threshold_val_TLM_PHSPEC 
    
    (PHSpecificaion (timeMaintainceMiliSecond ?tmm) (thresholdForMNT ?tfm) (weightForMNT ?wfm) (OBJECT ?PHSpecificaion))
    (test (> ?tmm ?tfm))
    =>
      (set ?PHSpecificaion weightForMNT(- ?wfm 0.2))
    	(printout t ?wfm "to" (get ?PHSpecificaion weightForMNT) crlf) (halt) )




(defrule check_threshold_val_ROC_CONDSPEC
    
    (ConducSpecification (rateOfChange ?roc) (thresholdForROC ?troc) (weightForROC ?wroc) (OBJECT ?ConducSpecification))
    (test (> ?roc ?troc))
    =>
      (set ?ConducSpecification weightForROC(- ?wroc 0.4))
    	(printout t ?wroc "to " (get ?ConducSpecification weightForROC) crlf ))


(defrule check_threshold_val_CAL_CONDSPEC
    
    (ConducSpecification (timeCalibrationMiliSecond ?tcm) (thresholdForCAL ?tcal) (weightForCAL ?wcal) (OBJECT ?ConducSpecification))
    (test (> ?tcm ?tcal))
    =>
      (set ?ConducSpecification weightForCAL(- ?wcal 0.3))
    	(printout t ?wcal "to" (get ?ConducSpecification weightForCAL) crlf))


(defrule check_threshold_val_TLM_CONDSPEC 
    
    (ConducSpecification (timeMaintainceMiliSecond ?tmm) (thresholdForMNT ?tfm) (weightForMNT ?wfm) (OBJECT ?ConducSpecification))
    (test (> ?tmm ?tfm))
    =>
      (set ?ConducSpecification weightForMNT(- ?wfm 0.2))
    	(printout t ?wfm "to" (get ?ConducSpecification weightForMNT) crlf))



(defrule check_threshold_val_ROC_OXYSPEC
    
    (OxySpecification (rateOfChange ?roc) (thresholdForROC ?troc) (weightForROC ?wroc) (OBJECT ?OxySpecification))
    (test (> ?roc ?troc))
    =>
      (set ?OxySpecification weightForROC(- ?wroc 0.4))
    	(printout t ?wroc "to " (get ?OxySpecification weightForROC) crlf ))


(defrule check_threshold_val_CAL_OXYSPEC
    
    (OxySpecification (timeCalibrationMiliSecond ?tcm) (thresholdForCAL ?tcal) (weightForCAL ?wcal) (OBJECT ?OxySpecification))
    (test (> ?tcm ?tcal))
    =>
      (set ?OxySpecification weightForCAL(- ?wcal 0.3))
    	(printout t ?wcal "to" (get ?OxySpecification weightForCAL) crlf))


(defrule check_threshold_val_TLM_OXYSPEC
    
    (OxySpecification (timeMaintainceMiliSecond ?tmm) (thresholdForMNT ?tfm) (weightForMNT ?wfm) (OBJECT ?OxySpecification))
    (test (> ?tmm ?tfm))
    =>
      (set ?OxySpecification weightForMNT(- ?wfm 0.2))
    	(printout t ?wfm "to" (get ?OxySpecification weightForMNT) crlf))



(defrule check_threshold_val_CAL_SALSPEC
    
    (SalSpecification (timeCalibrationMiliSecond ?tcm) (thresholdForCAL ?tcal) (weightForCAL ?wcal) (OBJECT ?SalSpecification))
    (test (> ?tcm ?tcal))
    =>
      (set ?SalSpecification weightForCAL(- ?wcal 0.3))
    	(printout t ?wcal "to" (get ?SalSpecification weightForCAL) crlf))


(defrule check_threshold_val_TLM_SALSPEC
    
    (SalSpecification (timeMaintainceMiliSecond ?tmm) (thresholdForMNT ?tfm) (weightForMNT ?wfm) (OBJECT ?SalSpecification))
    (test (> ?tmm ?tfm))
    =>
      (set ?SalSpecification weightForMNT(- ?wfm 0.2))
    	(printout t ?wfm "to" (get ?SalSpecification weightForMNT) crlf) (halt))


(defrule check_threshold_val_ROC_TWMPSPEC
    
    (TempSpecification (rateOfChange ?roc) (thresholdForROC ?troc) (weightForROC ?wroc) (OBJECT ?TempSpecification))
    (test (> ?roc ?troc))
    =>
      (set ?TempSpecification weightForROC(- ?wroc 0.4))
    	(printout t ?wroc "to " (get ?TempSpecification weightForROC) crlf ))


(defrule check_threshold_val_CAL_TEMPSPEC
    
    (TempSpecification (timeCalibrationMiliSecond ?tcm) (thresholdForCAL ?tcal) (weightForCAL ?wcal) (OBJECT ?TempSpecification))
    (test (> ?tcm ?tcal))
    =>
      (set ?TempSpecification weightForCAL(- ?wcal 0.3))
    	(printout t ?wcal "to" (get ?TempSpecification weightForCAL) crlf))
