/*
 * This file is part of NodeBox.
 *
 * Copyright (C) 2008 Frederik De Bleser (frederik@pandora.be)
 *
 * NodeBox is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NodeBox is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NodeBox. If not, see <http://www.gnu.org/licenses/>.
 */
package net.nodebox.graphics;

import junit.framework.TestCase;

public class RectTest extends TestCase {

    public void testEmpty() {
        assertFalse(new Rect(100, 100, 100, 100).isEmpty());
        assertFalse(new Rect(1, 1, 1, 1).isEmpty());
        assertFalse(new Rect(0, 0, 1, 1).isEmpty());
        assertFalse(new Rect(0, 0, -100, -200).isEmpty());

        assertTrue(new Rect(0, 0, 0, 0).isEmpty());
        assertTrue(new Rect(-10, 0, 0, 10).isEmpty());
        assertTrue(new Rect(-10, 0, 200, 0).isEmpty());
        assertTrue(new Rect(20, 30, 10, 0).isEmpty());
    }

    public void testIntersects() {
        assertFalse(new Rect(0, 0, 20, 20).intersects(new Rect(100, 100, 20, 20)));
        assertTrue(new Rect(0, 0, 20, 20).intersects(new Rect(0, 0, 20, 20)));
    }

    public void testUnited() {
        Rect r1 = new Rect(10, 20, 30, 40);
        Rect r2 = new Rect(40, 10, 50, 30);
        assertEquals(new Rect(10, 10, 80, 50), r1.united(r2));
    }

    public void testContains() {
        Rect r = new Rect(10, 20, 30, 40);
        assertTrue(r.contains(new Point(10, 20)));
        assertTrue(r.contains(new Point(11, 22)));
        assertTrue(r.contains(new Point(40, 60)));
        assertFalse(r.contains(new Point(0, 0)));
        assertFalse(r.contains(new Point(-11, -22)));
        assertFalse(r.contains(new Point(100, 200)));
        assertFalse(r.contains(new Point(15, 200)));
        assertFalse(r.contains(new Point(200, 25)));

        assertTrue(r.contains(new Rect(10, 20, 30, 40)));
        assertTrue(r.contains(new Rect(15, 25, 5, 5)));
        assertFalse(r.contains(new Rect(15, 25, 30, 40)));
        assertFalse(r.contains(new Rect(1, 2, 3, 4)));
        assertFalse(r.contains(new Rect(15, 25, 300, 400)));
        assertFalse(r.contains(new Rect(15, 25, 5, 400)));
        assertFalse(r.contains(new Rect(15, 25, 400, 5)));
    }
    
}
