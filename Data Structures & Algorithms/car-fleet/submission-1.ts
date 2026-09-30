class Solution {
    /**
     * @param {number} target
     * @param {number[]} position
     * @param {number[]} speed
     * @return {number}
     */
    carFleet(target: number, position: number[], speed: number[]): number {
        const cars = position.map((pos, i) => ({
            position: pos,
            time: (target-pos) / speed[i]
        }));

        cars.sort((a,b) => b.position - a.position);

        let fleets = 0;
        let fleetTime = 0;

        for (const car of cars) {
            if (car.time > fleetTime){
                fleets++;
                fleetTime = car.time;
            }
        }

        return fleets;
    }
}
