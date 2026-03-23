CREATE TABLE user_account
(
    id                    BIGINT PRIMARY KEY AUTO_INCREMENT,
    email                 VARCHAR(150) NOT NULL,
    first_name            VARCHAR(80)  NOT NULL,
    last_name_1           VARCHAR(80)  NOT NULL,
    last_name_2           VARCHAR(80) NULL,
    password_hash         VARCHAR(255) NOT NULL,
    role                  VARCHAR(30)  NOT NULL DEFAULT 'ROLE_USER',
    enabled               BOOLEAN      NOT NULL DEFAULT TRUE,
    failed_login_attempts INT          NOT NULL DEFAULT 0,
    last_login_at         TIMESTAMP NULL,
    created_at            TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at            TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT uk_user_account_email UNIQUE (email)
);

CREATE INDEX idx_user_account_enabled ON user_account (enabled);
CREATE INDEX idx_user_account_role ON user_account (role);
CREATE INDEX idx_user_account_name ON user_account (last_name_1, last_name_2, first_name);
