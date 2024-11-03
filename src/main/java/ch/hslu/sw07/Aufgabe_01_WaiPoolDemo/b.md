Führen Sie das Programm DemoWaitPool ohne Korrekturen aus.

    1)  Was passiert bei der Ausführung von DemoWaitPool?
Exception in thread "Thread-0" java.lang.IllegalMonitorStateException: current thread is not owner  
D.h. dass ein Thread auf eine Kritische stelle zugreifen wollte, jedoch nicht die Berechtigungen hatte.

    2)  Wie erklären Sie sich das Verhalten der Klassen?
Da der MyTask-Thread wait() ohne den Besitz des Locks aufruft, wird eine IllegalMonitorStateException ausgelöst. Das gleiche gilt für den LOCK.notify() Aufruf in der main()-Methode.

    3)  Welche minimalen Korrekturen sind nötig?
Bei MyTask:  
vor dem wait noch lock hinzufügen -> lock.wait();   
Bei DemoWaitPool: 
synchronized hinzufügen.

    4)  Gibt es noch andere Korrektur-Varianten?
mit True und False
