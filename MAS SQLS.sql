-- DROP SCHEMA IF EXISTS public CASCADE;
 --CREATE SCHEMA public;

insert into clinic (clinic_id, address) values (1, '822 Nova Way');
insert into clinic (clinic_id, address) values (2, '9772 Springview Plaza');
insert into clinic (clinic_id, address) values (3, '41 Fairview Street');
insert into clinic (clinic_id, address) values (4, '797 Dryden Road');
insert into clinic (clinic_id, address) values (5, '808 Doe Crossing Road');



insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (1, 'blemarquis0@dagondesign.com', 'Brigid', 'Le Marquis', false, '2009-04-03', 'Female', '2018-12-22', 'F1bLGSmlq', '9523896326');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (2, 'oplane1@guardian.co.uk', 'Olivie', 'Plane', false, '1993-05-20', 'Female', '2016-12-01', 'MgPOKz60CwAE', '8612652316');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (3, 'droebuck2@cbslocal.com', 'Desmund', 'Roebuck', true, '1985-09-16', 'Male', '2019-01-11', 'kdAuj2zJg', '0541457403');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (4, 'cbillinge3@whitehouse.gov', 'Celeste', 'Billinge', false, '2018-01-18', 'Female', '2016-06-19', 'V7nbVVFcTRw', '7557837797');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (5, 'jsagg4@tinyurl.com', 'Jacynth', 'Sagg', false, '1956-10-09', 'Female', '2017-07-11', 'LfJXcg8aTSuL', '5933570265');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (6, 'seyre5@rambler.ru', 'Stacee', 'Eyre', false, '2006-03-09', 'Male', '2015-03-17', 'B6g9XB6Sa9', '7896293447');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (7, 'cbouldon6@purevolume.com', 'Carmon', 'Bouldon', false, '1994-08-07', 'Female', '2019-10-21', 'bM01Owhodw', '1550583085');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (8, 'aseacroft7@go.com', 'Ambur', 'Seacroft', true, '1971-12-30', 'Female', '2019-11-07', 'UBI6r2OYISt', '9315550765');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (9, 'erysdale8@goo.gl', 'Emmett', 'Rysdale', true, '1965-01-02', 'Male', '2018-01-18', '2ygWIJiAoht', '8619404393');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (10, 'klait9@arstechnica.com', 'Korie', 'Lait', false, '1974-01-21', 'Female', '2015-07-03', 'YMfwJA9khQdC', '3866032897');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (11, 'adunsforda@mapy.cz', 'Aguie', 'Dunsford', true, '2019-06-12', 'Male', '2016-03-26', 'dFv0vXLjBUz', '0989108414');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (12, 'wfendlenb@ucoz.ru', 'Wilmar', 'Fendlen', true, '1987-03-19', 'Male', '2017-11-24', 'mNGV9tkoHI2', '1455204862');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (13, 'vcathelc@thetimes.co.uk', 'Violante', 'Cathel', false, '1955-05-31', 'Female', '2015-06-18', 'AceblpkU', '7834269208');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (14, 'gjoddinsd@forbes.com', 'Glynn', 'Joddins', true, '1987-06-20', 'Male', '2018-05-04', 'k4KkmJ', '0184000246');
insert into patient (user_id, email, first_name, last_name, sign_up_confirmed, birth_date, gender, register_date, password, pesel) values (15, 'ddorree@adobe.com', 'Dilly', 'Dorre', false, '1961-10-12', 'Male', '2017-05-26', 'kFGoRimq', '8597411260');

insert into patient_phone_number (patient_user_id, phone_number) values (1, '5098853420');
insert into patient_phone_number (patient_user_id, phone_number) values (2, '7386538482');
insert into patient_phone_number (patient_user_id, phone_number) values (3, '6039534024');
insert into patient_phone_number (patient_user_id, phone_number) values (4, '5157245910');
insert into patient_phone_number (patient_user_id, phone_number) values (5, '2679118252');
insert into patient_phone_number (patient_user_id, phone_number) values (6, '1828647302');
insert into patient_phone_number (patient_user_id, phone_number) values (7, '3672469470');
insert into patient_phone_number (patient_user_id, phone_number) values (8, '3473895984');
insert into patient_phone_number (patient_user_id, phone_number) values (9, '8951967425');
insert into patient_phone_number (patient_user_id, phone_number) values (10, '6154268129');
insert into patient_phone_number (patient_user_id, phone_number) values (11, '9656477749');
insert into patient_phone_number (patient_user_id, phone_number) values (12, '9448619295');
insert into patient_phone_number (patient_user_id, phone_number) values (13, '7537197291');
insert into patient_phone_number (patient_user_id, phone_number) values (14, '6251342978');
insert into patient_phone_number (patient_user_id, phone_number) values (15, '7076223913');




insert into specialist (user_id, email, first_name, last_name, sign_up_confirmed, description, hire_date, title, password, specialist_type, optometrist_type) values (1, 'ashreeves0@cisco.com', 'Andee', 'Shreeves', true, 'Phasellus in felis.', '2018-04-25', 'Graphic Designer', 'KhiK09m1Fj', 'OPTOMETRIST', 'INEXPERIENCED');
insert into specialist (user_id, email, first_name, last_name, sign_up_confirmed, description, hire_date, title, password, specialist_type, optometrist_type) values (2, 'cleverich1@archive.org', 'Cora', 'Leverich', false, 'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', '2018-04-10', 'Database Administrator I', '7xFHTEi4i', 'OPHTHALMOLOGIST', 'INEXPERIENCED');
insert into specialist (user_id, email, first_name, last_name, sign_up_confirmed, description, hire_date, title, password, specialist_type, optometrist_type) values (3, 'gschach2@state.tx.us', 'Garwood', 'Schach', true, 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue.', '2017-03-18', 'Operator', 'Bp8lcoYnVKBl', 'OPTOMETRIST_OPHTHALMOLOGIST', 'EXPERIENCED');
insert into specialist (user_id, email, first_name, last_name, sign_up_confirmed, description, hire_date, title, password, specialist_type, optometrist_type) values (4, 'bjeary3@gizmodo.com', 'Blondy', 'Jeary', false, 'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', '2016-11-08', 'Tax Accountant', 'g7zClkYHP44', 'OPTOMETRIST_OPHTHALMOLOGIST', 'EXPERIENCED');
insert into specialist (user_id, email, first_name, last_name, sign_up_confirmed, description, hire_date, title, password, specialist_type, optometrist_type) values (5, 'zschieferstein4@goodreads.com', 'Zolly', 'Schieferstein', true, 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', '2015-10-02', 'Office Assistant I', 'msGAs5LDroI5', 'OPTOMETRIST', 'EXPERIENCED');

insert into specialist_clinic (user_id, clinic_id) values (1, 1);
insert into specialist_clinic (user_id, clinic_id) values (2, 2);
insert into specialist_clinic (user_id, clinic_id) values (3, 3);
insert into specialist_clinic (user_id, clinic_id) values (4, 4);
insert into specialist_clinic (user_id, clinic_id) values (5, 5);


insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (1, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', 1.98, 9, 4);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (2, 'Mauris lacinia sapien quis libero.', 4.68, 9, 1);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (3, 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', 3.92, 8, 2);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (4, 'Nullam porttitor lacus at turpis.', 2.07, 3, 1);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (5, 'Cras pellentesque volutpat dui.', 1.74, 5, 3);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (6, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', 2.57, 10, 3);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (7, 'Vivamus in felis eu sapien cursus vestibulum.', 1.74, 9, 4);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (8, 'Nullam molestie nibh in lectus.', 4.31, 1, 1);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (9, 'In eleifend quam a odio.', 2.12, 11, 5);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (10, 'Nulla tellus.', 1.04, 13, 3);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (11, 'Praesent blandit.', 3.06, 10, 3);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (12, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 1.88, 7, 5);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (13, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 3.94, 1, 4);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (14, 'Sed vel enim sit amet nunc viverra dapibus.', 4.91, 10, 2);
insert into patient_specialist_review (patient_specialist_review_id, comment, rating, patient_user_id, specialist_user_id) values (15, 'Phasellus id sapien in sapien iaculis congue.', 4.01, 15, 3);


insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (1, '2019-07-09', 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', 'COMPLETED', '10:06:53', 172, 'OPTOMETRICAL', 3, 1, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (2, '2020-01-18', 'Phasellus in felis. Donec semper sapien a libero.', 'COMPLETED', '22:50:32', 109, 'OPTOMETRICAL', 2, 5, 5);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (3, '2019-10-05', 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.', 'COMPLETED', '11:47:20', 51, 'OPTOMETRICAL', 1, 1, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (4, '2019-12-22', 'Curabitur convallis.', 'COMPLETED', '4:53:07', 121, 'OPHTHALMOLOGICAL', 5, 8, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (5, '2019-12-30', 'Nulla justo. Aliquam quis turpis eget elit sodales scelerisque.', 'COMPLETED', '20:18:15', 198, 'OPHTHALMOLOGICAL', 2, 12, 4);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (6, '2019-02-07', 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.', 'PLANNED', '19:16:07', 114, 'OPHTHALMOLOGICAL', 2, 9, 5);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (7, '2019-12-12', 'Vestibulum ac est lacinia nisi venenatis tristique.', 'PLANNED', '14:08:04', 94, 'OPHTHALMOLOGICAL', 1, 7, 5);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (8, '2019-07-26', 'Nulla ut erat id mauris vulputate elementum. Nullam varius.', 'PLANNED', '3:32:21', 68, 'OPHTHALMOLOGICAL', 3, 6, 2);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (9, '2019-06-21', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', 'COMPLETED', '16:27:46', 179, 'OPHTHALMOLOGICAL', 3, 4, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (10, '2019-07-15', 'Vivamus vel nulla eget eros elementum pellentesque.', 'PLANNED', '18:01:23', 91, 'OPTOMETRICAL', 4, 4, 1);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (11, '2019-02-07', 'In hac habitasse platea dictumst. Etiam faucibus cursus urna.', 'COMPLETED', '10:09:36', 196, 'OPTOMETRICAL', 2, 15, 1);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (12, '2019-12-14', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'COMPLETED', '2:37:43', 176, 'OPHTHALMOLOGICAL', 2, 7, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (13, '2019-08-15', 'Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 'CANCELLED', '21:29:51', 167, 'OPHTHALMOLOGICAL', 1, 14, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (14, '2019-06-11', 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', 'COMPLETED', '0:28:57', 197, 'OPHTHALMOLOGICAL', 3, 11, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (15, '2019-11-27', 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 'COMPLETED', '3:13:21', 136, 'OPTOMETRICAL', 1, 15, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (16, '2019-05-24', 'Nullam sit amet turpis elementum ligula vehicula consequat.', 'PLANNED', '16:42:38', 156, 'OPTOMETRICAL', 5, 10, 2);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (17, '2019-06-28', 'Nunc nisl.', 'CANCELLED', '10:39:52', 135, 'OPTOMETRICAL', 5, 7, 4);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (18, '2019-05-01', 'Sed accumsan felis.', 'COMPLETED', '13:22:06', 71, 'OPTOMETRICAL', 5, 4, 2);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (19, '2019-08-05', 'Donec vitae nisi.', 'PLANNED', '23:06:21', 168, 'OPTOMETRICAL', 3, 13, 1);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (20, '2019-07-30', 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', 'COMPLETED', '2:08:25', 183, 'OPTOMETRICAL', 5, 5, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (21, '2019-04-11', 'Nulla ac enim.', 'CANCELLED', '20:20:53', 56, 'OPTOMETRICAL', 3, 11, 2);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (22, '2019-05-30', 'Phasellus in felis.', 'PLANNED', '13:15:26', 165, 'OPTOMETRICAL', 1, 11, 2);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (23, '2019-08-04', 'Sed vel enim sit amet nunc viverra dapibus.', 'COMPLETED', '14:39:24', 103, 'OPTOMETRICAL', 2, 14, 2);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (24, '2019-06-04', 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.', 'PLANNED', '5:20:02', 95, 'OPHTHALMOLOGICAL', 3, 14, 4);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (25, '2020-01-25', 'Nulla ut erat id mauris vulputate elementum.', 'CANCELLED', '9:03:43', 174, 'OPHTHALMOLOGICAL', 2, 7, 4);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (26, '2019-12-23', 'Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 'COMPLETED', '21:33:43', 182, 'OPHTHALMOLOGICAL', 5, 9, 4);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (27, '2019-08-09', 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', 'PLANNED', '10:11:51', 128, 'OPTOMETRICAL', 3, 2, 4);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (28, '2019-12-12', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.', 'COMPLETED', '17:42:26', 166, 'OPHTHALMOLOGICAL', 3, 9, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (29, '2019-09-12', 'Morbi non lectus.', 'COMPLETED', '12:58:44', 157, 'OPTOMETRICAL', 2, 11, 3);
insert into visit (visit_id, date, description, status, time, price, visit_type, specialist_user_id, patient_user_id, clinic_clinic_id) values (30, '2019-11-08', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 'COMPLETED', '10:37:48', 122, 'OPHTHALMOLOGICAL', 5, 15, 4);

insert into medical_examinations (examination_name, examination_price, visit_id) values ('Total elbow replacement', '130.89', 11);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Implant leg prosthesis', '209.13', 17);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Cell blk/pap-lymph sys', '37.28', 18);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Translum cor atherectomy', '60.42', 19);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Remove ventricle shunt', '24.54', 6);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Interat ven retrn transp', '29.77', 3);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Trnsplnt live nonrel don', '190.10', 14);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Liver scan/isotope funct', '104.44', 21);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Vaginal biopsy', '41.09', 4);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Solitary kidney nephrect', '31.08', 21);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Ocular prosthetics', '242.46', 22);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Delayed clos abd wound', '146.49', 10);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Psychol mental stat NOS', '178.42', 10);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Ins/re pls gn no rechrg', '75.46', 9);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Stapedect w replac incus', '201.37', 19);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Other heart septa ops', '148.16', 1);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Exploratory laparotomy', '75.96', 24);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Cl reduct malar/zygo fx', '116.28', 5);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Thumb reconstruction NEC', '127.59', 20);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Seg osteoplasty maxilla', '247.36', 9);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Thorac duct cannulation', '168.04', 4);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Negatve-contr cardiogram', '68.64', 3);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Dx ultrasound-vascular', '210.31', 22);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Lo limb sft tis xray NEC', '200.26', 6);
insert into medical_examinations (examination_name, examination_price, visit_id) values ('Opn/oth rep hrt vlv NOS', '75.17', 7);