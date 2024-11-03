Reflektieren Sie die Aufgabe (hilft auch bei einer eventuellen Präsentation) und beantworten Sie sich die folgenden Fragen:

    1)  Warum müssen beim Bounded Buffer mit Semaphoren nicht mehr die ganzen Methoden synchronisiert sein?
Semaphoren steuern den Zugang zum Puffer, wodurch nur kritische Abschnitte synchronisiert werden müssen, was die Effizienz erhöht.

    2)  Sie haben bei denjenigen Methoden wo eine InterruptedException auftreten kann, diese an den Aufrufer weitergegeben. Warum macht dies Sinn?
So kann der Aufrufer auf den Interrupt reagieren und geeignete Maßnahmen ergreifen, was die Robustheit des Codes verbessert.

    3)  Wie verhält sich Ihr BoundedBuffer beim Eintreffen eines Interrupts? Haben Sie das  ausprobiert?
Der Thread wird aus der Warteschleife entfernt und löst eine InterruptedException aus, was den Zustand des Buffers beeinflussen kann.