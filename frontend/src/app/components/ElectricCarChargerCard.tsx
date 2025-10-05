import { Dispatch, SetStateAction } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";

export default function ElectricCarChargerCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Electric Car Charger" onSubmit={onSubmit}>
      asd
    </HomeStateCardTemplate>
  );
}
