CREATE DATABASE IF NOT EXISTS `opticus_db`;
USE `opticus_db`;

DROP TABLE IF EXISTS VISIT;
DROP TABLE IF EXISTS DOCTOR;
DROP TABLE IF EXISTS PATIENT;



CREATE TABLE DOCTOR
(
    `id`             INT NOT NULL AUTO_INCREMENT,

    `first_name`     varchar(45)  DEFAULT NULL,
    `last_name`      varchar(45)  DEFAULT NULL,
    `pesel`          varchar(45)  DEFAULT NULL,
    `birthdate`      date         DEFAULT NULL,
    `sex`            varchar(45)  DEFAULT NULL,
    `title`          varchar(45)  DEFAULT NULL,
    `email`          varchar(45)  DEFAULT NULL,
    `specialisation` varchar(45)  DEFAULT NULL,
    `description`    varchar(500) DEFAULT NULL,
    `rating`         double       DEFAULT NULL,
    `hire_date`      date         DEFAULT NULL,
    `fire_date`      date         DEFAULT NULL,
    PRIMARY KEY (`id`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE PATIENT
(

    `id`            INT NOT NULL AUTO_INCREMENT,

    `first_name`    varchar(45) DEFAULT NULL,
    `last_name`     varchar(45) DEFAULT NULL,
    `pesel`         varchar(45) DEFAULT NULL,
    `birthdate`     date        DEFAULT NULL,
    `sex`           varchar(45) DEFAULT NULL,
    `email`         varchar(45) DEFAULT NULL,
    `register_date` date        DEFAULT NULL,
    `phone_number`  varchar(45) DEFAULT NULL,
    `kuz`           varchar(45) DEFAULT NULL,
    `blood_type`    varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)


) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE VISIT
(

    `id`          INT NOT NULL auto_increment,
    `patient_id`  INT NOT NULL,
    `doctor_id`   INT NOT NULL,
    `clinic`      varchar(45)  default null,
    `description` varchar(150) DEFAULT NULL,
    `reason`      varchar(150) DEFAULT NULL,
    `visit_type`  varchar(45)  DEFAULT NULL,
    `is_planned`  boolean,
    `date`        datetime     DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`patient_id`) REFERENCES PATIENT (`id`),
    FOREIGN KEY (`doctor_id`) REFERENCES DOCTOR (`id`)


) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;



INSERT INTO `PATIENT` (first_name, last_name, pesel, birthdate, sex, email, register_date, phone_number, kuz,
                       blood_type)
VALUES ('Jan', 'Kowalski', 95020212345, Date('1995-02-02'), 'M', 'jan.kowalski@gmail.com', Date('2018-01-01'),
        664456654, 'A23z', 'A'),
       ('Anna', 'Nowak', 90112123456, Date('1990-02-02'), 'F', 'anna.nowak@gmail.com', Date('2018-11-06'), 664123454,
        'ABa123z', 'B'),
       ('Jagoda', 'Iksinska', 92040412654, Date('1992-02-02'), 'F', 'jagoda.iksinska@gmail.com', Date('2019-05-10'),
        664486434, 'Z123v3z', 'AB'),
       ('Admin', 'Admin', 80040412654, Date('1980-02-02'), 'M', 'admin.admin@gmail.com', Date('2019-05-10'), 123123123,
        'Z123v3z', 'AB');



INSERT INTO `DOCTOR` (first_name, last_name, pesel, birthdate, sex, title, email, specialisation, description, rating,
                      hire_date, fire_date)
VALUES ('Jan', 'Okulistyczny', 6110212345, Date("1961-11-02"), "M", 'M.D', 'jan.okulistyczny@gmail.com',
        'Cornea and External Disease',
        'Vestibulum ut tincidunt ex. Nulla ornare scelerisque felis vel hendrerit. Praesent a suscipit nisl. Nam purus ante, venenatis non fermentum vulputate, interdum vitae lorem.',
        4.5, Date("2017-12-12"), null),
       ('Marlena', 'Doktorska', 75020212345, Date("1975-02-02"), "F", 'M.D', 'marlena.doktorska@gmail.com',
        'Ophthalmic Pathology',
        'Fusce in odio mi. Proin tincidunt tempor felis, sagittis elementum nisl. Praesent tristique aliquam accumsan.',
        3.5, Date("2015-12-02"), null);


INSERT INTO `VISIT` (patient_id, doctor_id, clinic, description, reason, visit_type, is_planned, date)
VALUES (1, 1, 'Warszawa, Pulawska 427',
        'Phasellus ut placerat orci. Nullam lobortis condimentum ligula suscipit faucibus.', 'ligula suscipit faucibus',
        'Pre-surgery', false, '2019-12-11 12:30:00'),
       (1, 1, 'Gdynia, Morska 15',
        'Leo vel fringilla est ullamcorper. Nulla aliquet porttitor lacus luctus accumsan tortor',
        'Neque viverra justo nec ultrices dui sapien.', 'Post-surgery', true, '2020-03-18 14:30:00'),
       (1, 2, 'Warszawa, Pulawska 427',
        'Nam at lectus urna duis convallis. Habitant morbi tristique senectus et netus et malesuada fames ac. Imperdiet sed euismod nisi porta lorem mollis',
        'Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend', 'Regular check-up', false,
        '2018-06-20 18:00:00'),
       (2, 2, 'Gdynia, Morska 15',
        'Vitae nunc sed velit dignissim sodales ut eu. Quis blandit turpis cursus in hac habitasse platea dictumst quisque. ',
        'Viverra nam libero justo laoreet sit.', 'Regular check-up', false, '2017-01-15 09:45:00'),
       (2, 2, 'Gdynia, Morska 15', 'Auctor augue mauris augue neque gravida in fermentum et sollicitudin',
        'Et odio pellentesque diam volutpat commodo.', 'Emergency', false, '2019-09-11 16:00:00'),
       (3, 1, 'Warszawa, Pulawska 427',
        'Enim diam vulputate ut pharetra sit amet aliquam id. Sollicitudin nibh sit amet commodo nulla facilisi nullam.',
        ' Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula.', 'Pre-surgery visit', true,
        '2020-01-07 19:00:00'),
       (3, 2, 'Gdynia, Morska 15',
        'At erat pellentesque adipiscing commodo elit at. Aliquet bibendum enim facilisis gravida neque convallis',
        'Proin sed libero enim sed', 'Regular check-up', false, '2019-02-11 11:15:00')




