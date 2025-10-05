import { Dispatch, SetStateAction } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";

export default function WashingMachineCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Washing Machine" onSubmit={onSubmit}>
      asd
    </HomeStateCardTemplate>
  );
}
