DELIMITER $$

CREATE PROCEDURE select_all_from_user()

BEGIN

    SELECT * from users;

    END$$

DELIMITER ;
call select_all_from_user();

DELIMITER $$

CREATE PROCEDURE edit_user_by_SP(
IN user_id INT,

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    update users
    set name=user_name,
    email=user_email,
    country=user_country
    where id=user_id;

    END$$

DELIMITER ;

call edit_user_by_SP(6,'MrTuan','mrtuan@tuan','Viet Nam');

DELIMITER $$

CREATE PROCEDURE delete_by_ID_by_SP(IN user_id INT)

BEGIN

    delete FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

call delete_by_ID_by_SP(6);