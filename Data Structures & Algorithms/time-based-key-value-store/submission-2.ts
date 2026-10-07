class TimeMap {
    private keyStore: Map<string, { timestamp: number; value: string }[]>;

    constructor() {
        this.keyStore = new Map();
    }

    /**
     * @param {string} key
     * @param {string} value
     * @param {number} timestamp
     * @return {void}
     */
    set(key: string, value: string, timestamp: number): void {
        if (!this.keyStore.has(key)) this.keyStore.set(key, []);

        this.keyStore.get(key).push({ timestamp, value });
    }

    /**
     * @param {string} key
     * @param {number} timestamp
     * @return {string}
     */
    get(key: string, timestamp: number): string {
        const entries = this.keyStore.get(key);
        if (entries === undefined) return "";

        let l = 0;
        let r = entries.length - 1;
        let result = "";

        while (l <= r) {
            let m = Math.floor((l + r) / 2);

            if (entries[m].timestamp <= timestamp) {
                result = entries[m].value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }
}
