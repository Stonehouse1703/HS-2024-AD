Das im AD Input N21 (N21_IP_ThreadSteuerung) vorgestellte Semaphor hat in der
Methode release noch Potential zur Verbesserung. 

    1)  Welche ist das?
Den Semaphore-Zähler zu beschränken, sodass er nciht über einen bestimmten Wert hinaus erhöht wird.

    2)  Was benötigen Sie um das Verbesserungspotential umzusetzen?
- Eine maximale Kapazität für den Semaphore 
- Überprüfung der release-Methode (überprüfung ob der aktuelle Wert des Zählers unter dem maximalen Wert liegt)
