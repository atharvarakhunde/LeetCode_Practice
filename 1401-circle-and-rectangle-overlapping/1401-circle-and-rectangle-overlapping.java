class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest x-coordinate on the rectangle to the circle's center
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        
        // Find the closest y-coordinate on the rectangle to the circle's center
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate the horizontal and vertical distance from the center to this point
        int distX = xCenter - nearestX;
        int distY = yCenter - nearestY;
        
        // Check if distance squared is <= radius squared
        return (distX * distX + distY * distY) <= radius * radius;
    }
}
