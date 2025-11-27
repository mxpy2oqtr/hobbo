-- PostgreSQL Schema for Health Tracking Application

-- Set timezone to UTC for consistency
SET TIMEZONE="UTC";

-- Table for Users
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    gender VARCHAR(20),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

-- Table for Daily Health Metrics
CREATE TABLE health_metrics (
    metric_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    metric_date DATE NOT NULL,
    weight_kg DECIMAL(5, 2),
    body_fat_percentage DECIMAL(4, 2),
    sleep_hours DECIMAL(4, 2),
    steps_count INT,
    calories_burned INT,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,
    UNIQUE (user_id, metric_date) -- Ensures one entry per user per day
);

-- Table for Meals
CREATE TABLE meals (
    meal_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    meal_date TIMESTAMPTZ NOT NULL,
    meal_type VARCHAR(50) NOT NULL, -- e.g., Breakfast, Lunch, Dinner, Snack
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
);

-- Table for Individual Food Items within a Meal
CREATE TABLE meal_items (
    item_id SERIAL PRIMARY KEY,
    meal_id INT NOT NULL,
    food_name VARCHAR(100) NOT NULL,
    calories INT NOT NULL,
    protein_g DECIMAL(5, 2),
    carbs_g DECIMAL(5, 2),
    fat_g DECIMAL(5, 2),
    CONSTRAINT fk_meal
        FOREIGN KEY(meal_id)
        REFERENCES meals(meal_id)
        ON DELETE CASCADE
);

-- Table for Physical Activities/Exercises
CREATE TABLE exercises (
    exercise_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    exercise_date TIMESTAMPTZ NOT NULL,
    activity_type VARCHAR(100) NOT NULL, -- e.g., Running, Weightlifting
    duration_minutes INT NOT NULL,
    calories_burned INT,
    notes TEXT,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
);

-- Table for User Goals
CREATE TABLE goals (
    goal_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    goal_type VARCHAR(100) NOT NULL, -- e.g., Weight Loss, Muscle Gain
    target_value DECIMAL(10, 2) NOT NULL,
    start_value DECIMAL(10, 2),
    start_date DATE NOT NULL,
    target_date DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'Active', -- e.g., Active, Completed, Canceled
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
);

-- Table for Tracking Progress Towards Goals
CREATE TABLE progress_history (
    progress_id SERIAL PRIMARY KEY,
    goal_id INT NOT NULL,
    progress_date DATE NOT NULL,
    current_value DECIMAL(10, 2) NOT NULL,
    notes TEXT,
    CONSTRAINT fk_goal
        FOREIGN KEY(goal_id)
        REFERENCES goals(goal_id)
        ON DELETE CASCADE,
    UNIQUE (goal_id, progress_date)
);

-- Optional: Table for Messages (if implementing a messaging feature)
CREATE TABLE messages (
    message_id SERIAL PRIMARY KEY,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    message_content TEXT NOT NULL,
    sent_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    is_read BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_sender
        FOREIGN KEY(sender_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_receiver
        FOREIGN KEY(receiver_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
);
