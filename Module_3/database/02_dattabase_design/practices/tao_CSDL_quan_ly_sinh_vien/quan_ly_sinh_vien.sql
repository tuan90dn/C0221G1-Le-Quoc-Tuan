create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
CREATE TABLE class
(
    class_ID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    start_date DATETIME    NOT NULL,
    Status    BIT
);
CREATE TABLE student
(
    student_Id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    dddress     VARCHAR(50),
    phone       VARCHAR(20),
    Status      BIT,
    class_ID     INT         NOT NULL,
    FOREIGN KEY (class_ID) REFERENCES class (class_ID)
);
CREATE TABLE subject
(
    sub_ID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( credit >= 1 ),
    Status  BIT                  DEFAULT 1
);
CREATE TABLE mark
(
    mark_ID    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_ID     INT NOT NULL,
    student_ID INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    UNIQUE (sub_ID, student_ID),
    FOREIGN KEY (sub_ID) REFERENCES Subject (sub_ID),
    FOREIGN KEY (student_ID) REFERENCES student (student_ID)
);
select * from class;
select * from student;
select * from subject;
select * from mark;