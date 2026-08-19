WITH FilteredStadium AS (
    -- Step 1: Filter for >= 100 people and assign a row number
    SELECT 
        id, 
        visit_date, 
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
),
GroupedStadium AS (
    -- Step 2: Count how many rows are in each consecutive group
    SELECT 
        id, 
        visit_date, 
        people,
        COUNT(*) OVER (PARTITION BY grp) AS group_count
    FROM FilteredStadium
)
-- Step 3: Filter groups with 3 or more rows and sort
SELECT 
    id, 
    visit_date, 
    people
FROM GroupedStadium
WHERE group_count >= 3
ORDER BY visit_date ASC;