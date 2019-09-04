package com.myapp.test.sqlitetest;

import com.myapp.test.sqlitetest.entity.Car;

import static com.myapp.test.sqlitetest.MainActivity.database;

public class FillDataBase {
    public FillDataBase() {
        fillCar();
    }

    private void fillCar() {

        database.carDao().addCar(new Car("Nissan", "Almera 1.4", "Япония", R.drawable.nissan_almera, "январь 1998 г.", "хэтчбек 3 дв.", "1392 cм3", "75 л.с.", 135000));
        database.carDao().addCar(new Car("Toyota", "Allion 1.5", "Япония", R.drawable.toyota_allion, "январь 2005 г.", "седан 4 дв.", "1496 cм3", "109 л.с.", 430000));
        database.carDao().addCar(new Car("Mazda", "2 1.3", "Япония", R.drawable.mazda_2, "ноябрь 2008 г.", " хэтчбек 5 дв.", "1349 cм3", "75 л.с.", 354707));
        database.carDao().addCar(new Car("Geely", "Emgrand EC7 1.5", "Китай", R.drawable.geely_emgrand, "2014 г.", "седан 4 дв.", "1498 cм3", " 98 л.с", 365000));
        database.carDao().addCar(new Car("Chery", "A1/Kimo 1.3", "Китай", R.drawable.chery_a1, " 2009 г.", "хэтчбек 5 дв.", "1297 cм3", "83 л.с.", 155000));
        database.carDao().addCar(new Car("Lifan", "320 1.3", "Китай", R.drawable.lifan_320, "июль 2013 г.", "хэтчбек 5 дв.", "1342 cм3", "89 л.с.", 220000));
        database.carDao().addCar(new Car("Audi", "A3 1.2 TFSI", "Германия", R.drawable.audi_a3, "январь 2009 г.", "кабриолет 2 дв.", "1197 cм3", "105 л.с.", 595000));
        database.carDao().addCar(new Car("Volkswagen", "Golf", "Германия", R.drawable.volkswagen_golf, "январь 2014 г.", "купе 3 дв.", "2000 cм3", "301 л.с.", 2000000));
        database.carDao().addCar(new Car("Opel", "Antara 2.0", "Германия", R.drawable.opel_antara, "январь 2008 г.", "внедорожник 5 дв.", "1991 cм3", "127 л.с.", 20011));
        database.carDao().addCar(new Car("Opel", "Calibra 2.0", "Германия", R.drawable.opel_calibra, "1991 г.", "купе 2 дв.", "1998 cм3", "115 л.с.", 90000));
        database.carDao().addCar(new Car("Opel", "Omega B 2.0", "Германия", R.drawable.opel_omega, "сентябрь 1995 г.", "седан 4 дв.", "1998 cм3", "136 л.с.", 75000));
        database.carDao().addCar(new Car("Opel", "Zafira 1.6", "Германия", R.drawable.opel_zafira, "ноябрь 2000 г.", "минивэн 5 дв.", "1598 cм3", "101 л.с.", 296280));

    }
}
