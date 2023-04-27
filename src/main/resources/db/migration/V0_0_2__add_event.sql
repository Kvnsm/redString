CREATE TABLE event
(
    event_id    BIGSERIAL PRIMARY KEY,
    title       VARCHAR(200)                NOT NULL,
    start_date  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_date    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    all_day     BOOLEAN,
    course_id   BIGINT
);
